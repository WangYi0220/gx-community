package com.gx.community.service;

import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.TeacherMapper;
import com.gx.community.pojo.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 16:22
 * @description：管理-教师
 * @modified By：
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 导入教师信息
     *
     * @param multipartFile
     */
    @Override
    public void importTeacherInfo(MultipartFile multipartFile) {
        try {
            List<Teacher> teachers = new ArrayList<Teacher>();
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheetAt = workbook.getSheetAt(0);
            for (Row row : sheetAt) {
                if (row.getRowNum() == 0 || row.getRowNum() == 1){
                    continue;
                }
                String teacherName = row.getCell(0).getStringCellValue();
                String phone = row.getCell(1).getStringCellValue();
                if ("" == teacherName.trim() || "".equals(teacherName.trim())) continue;
                teachers.add(new Teacher(UUIDUtils.getUUID(), phone, teacherName, phone));
            }
            teachers.forEach(item -> {
                System.out.println(item.toString());
            });
            teacherMapper.importTeacherInfo(teachers);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改老师信息（姓名、电话）
     * @param teacher
     */
    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    /**
     * 根据教师姓名模糊查询
     * @param teaName
     * @return
     */
    @Override
    public List<Map<String, Object>> getTeacherByTeaName(String teaName) {
        return teacherMapper.getTeacherByTeaName(teaName);
    }

    @Override
    public Teacher getTeacherByTeaUUID(String teaUUID){
        return teacherMapper.getTeacherByTeaUUID(teaUUID);
    }
}
