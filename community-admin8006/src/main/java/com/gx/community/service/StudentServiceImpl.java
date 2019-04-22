package com.gx.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.StudentMapper;
import com.gx.community.pojo.Student;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author ：lxl
 * @date ：Created in 2019/4/2 21:11
 * @description：学生
 * @modified By：
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * @Auther WangYi
     * @param classUUID
     * @return
     */
    @Override
    public ResponseEntity<InputStreamResource> downloadStudentBaseInfoByClassUUID(String classUUID) {
        ResponseEntity<InputStreamResource> response = null;
        try {
            List<Map<String, Object>> studentBaseInfoByClassUUID = studentMapper.getStudentBaseInfoByClassUUID(classUUID);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet xssfSheet = workbook.createSheet();
            XSSFRow titleRow = xssfSheet.createRow(0);
            titleRow.createCell(0).setCellValue("学生编号");
            titleRow.createCell(1).setCellValue("学生姓名");
            titleRow.createCell(2).setCellValue("家长姓名");
            titleRow.createCell(3).setCellValue("家长联系方式");
            titleRow.createCell(4).setCellValue("家长所在单位");
            titleRow.createCell(5).setCellValue("关系");
            studentBaseInfoByClassUUID.forEach(item -> {
                System.out.println(item);
                int lastRowNum = xssfSheet.getLastRowNum();
                XSSFRow dataRow = xssfSheet.createRow(lastRowNum + 1);
                dataRow.createCell(0).setCellValue((String) item.get("stuUUID"));
                dataRow.createCell(1).setCellValue((String) item.get("stuName"));
            });
            String fileName = (String) studentBaseInfoByClassUUID.get(0).get("className") + ".xlsx";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //将excel文件写入输出流
            workbook.write(out);
            workbook.close();
            InputStream excelStream = new ByteArrayInputStream(out.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("gbk"), "iso8859-1"));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            response = ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/octet-stream")).body(new InputStreamResource(excelStream));
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *@Author lxl
     *@Description 根据班级编号查看对应的学生信息列表，实现分页功能
     *@Date 19:48 2019/4/3
     *@Param [classUUID,pageNum]
     *@return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @Override
    public PageInfo<Map<String, Object>> getStudentInfoByClassUUID(String classUUID,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Map<String, Object>> studentList = studentMapper.getStudentInfoByClassUUID(classUUID);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(studentList);
        return pageInfo;
    }

    /**
     *@Author lxl
     *@Description 根据学生编号查询对应的学生信息
     *@Date 8:39 2019/4/3
     *@Param [stuUUID]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @Override
    public Map<String, Object> queryByStuUUID(String stuUUID) {
        return studentMapper.queryByStuUUID(stuUUID);
    }

    /**
     *@Author lxl
     *@Description 添加学生信息
     *@Date 8:39 2019/4/3
     *@Param [student]
     *@return java.lang.String
     **/
    @Override
    public String addStudent(Student student) {
        String stuUUID = UUIDUtils.getUUID();
        student.setStuUUID(stuUUID);
        System.out.println("student-service = " + student);
        studentMapper.addStudent(student);
        return stuUUID;
    }

    /**
     *@Author lxl
     *@Description 删除学生信息
     *@Date 8:40 2019/4/3
     *@Param [stuUUID]
     *@return java.lang.Boolean
     **/
    @Override
    public Boolean delStudent(String stuUUID) {
        studentMapper.delStudent(stuUUID);
        return true;
    }

    /**
     *@Author lxl
     *@Description 修改学生信息
     *@Date 8:40 2019/4/3
     *@Param [student]
     *@return java.lang.Boolean
     **/
    @Override
    public Boolean updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return true;
    }
}
