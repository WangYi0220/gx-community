package com.gx.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.RedisUtils;
import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.NationMapper;
import com.gx.community.mapper.StudentMapper;
import com.gx.community.pojo.Nation;
import com.gx.community.pojo.Student;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description impl:StudentServiceImpl
 * @Author shiloh
 * @Date 2019/4/8
 * @Version 1.0
 **/
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private NationMapper nationMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * @return com.github.pagehelper.PageInfo<com.gx.community.teacher.pojo.Student>
     * @Author lxl
     * @Description 根据班级编号查看对应班级所有学生信息列表(实现分页)
     * @Date 10:59 2019/4/8
     * @Param [classUUID, pageNum]
     **/
    @Override
    public PageInfo<Student> queryStudentListByClassUUID(String classUUID, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Student> students = studentMapper.queryStudentListByClassUUID(classUUID);
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);
        return pageInfo;
    }

    /**
     * @return java.util.Map<java.lang.String       ,       java.lang.Object>
     * @Author lxl
     * @Description 根据学生编号查看对应学生的详细信息
     * @Date 10:51 2019/4/8
     * @Param [stuUUID]
     **/
    public Map<String, Object> queryByStuUUID(String stuUUID) {
        return studentMapper.queryByStuUUID(stuUUID);
    }

    @Override
    public void addStudent(MultipartFile multipartFile, String classUUID) {
        List<Nation> nations = null;
        if (redisUtils.hasKey("nations")) nations = (List<Nation>) redisUtils.get("nations");
        else {
            nations = nationMapper.getAll();
            redisUtils.set("nations", nations, 0);
        }
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = new ArrayList<Student>();
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheetAt = workbook.getSheetAt(0);
            for (Row row : sheetAt) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                Student student = new Student();
                String uuid = UUIDUtils.getUUID();
                String stuNO = row.getCell(0).getStringCellValue();
                String stuName = row.getCell(1).getStringCellValue();
                if (""==stuName.trim() || "".equals(stuName.trim())) continue;
                String sex = row.getCell(2).getStringCellValue();
                String nation = row.getCell(3).getStringCellValue();
                String accountLoc = row.getCell(4).getStringCellValue();
                String telephone = row.getCell(5).getStringCellValue();
                String idCard = row.getCell(6).getStringCellValue();
                String polStatus = row.getCell(7).getStringCellValue();
                String accountType = row.getCell(8).getStringCellValue();
                String familyAdd = row.getCell(9).getStringCellValue();
                String graSchool = row.getCell(10).getStringCellValue();
                String eduLevel = row.getCell(11).getStringCellValue();
                student.setStuUUID(uuid);
                student.setStuNO(stuNO);
                student.setStuName(stuName);
                if ("男".equals(sex.trim()))student.setSex("1");
                else student.setSex("0");
                nations.forEach(item -> {
                    if (item.getNationName().equals(nation))student.setNationID(item.getNationID()+"");
                });
                student.setAccountLoc(accountLoc);
                student.setIdCard(idCard);
                student.setTelephone(telephone);
                if ("群众".equals(polStatus.trim()))student.setPolStatus("0");
                else if ("群众".equals(polStatus.trim()))student.setPolStatus("1");
                else student.setPolStatus("2");
                if ("城镇".equals(accountType.trim()))student.setAccountType("0");
                else student.setAccountType("1");
                student.setFamilyAdd(familyAdd);
                student.setGraSchool(graSchool);
                if("中专".equals(eduLevel.trim()))student.setEduLevel("0");
                else student.setEduLevel("1");
                student.setPassword(telephone);
                student.setClassUUID(classUUID);
                students.add(student);
            }
            students.forEach(item -> {
                System.out.println(item);
                mapper.addStudent(item);
            });
            sqlSession.flushStatements();
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
