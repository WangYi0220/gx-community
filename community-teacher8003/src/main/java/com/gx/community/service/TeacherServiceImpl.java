package com.gx.community.service;

import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.TeacherMapper;
import com.gx.community.pojo.ClassInfo;
import com.gx.community.pojo.StudentScore;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
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
 * @ClassName TeacherServiceImpl
 * @Description impl:TeacherServiceImpl
 * @Author lxl
 * @Date 2019/4/8
 * @Version 1.0
 **/
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     *@Author lxl
     *@Description 查看当前教师所带班级列表(分级查询，如：2017级、2018级)
     *@Date 9:44 2019/4/8
     *@Param [teaUUID, grade]
     *@return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @Override
    public List<Map<String, Object>> queryClassInfoListByTeaUUIDAndGrade(String teaUUID, String grade) {
        return teacherMapper.queryClassInfoListByTeaUUIDAndGrade(teaUUID,grade);
    }

    /**
     *@Author lxl
     *@Description 导入学生成绩信息
     *@Date 19:41 2019/4/8
     *@Param [multipartFile]
     *@return void
     **/
    @Override
    public void importStudentScoreInfo(MultipartFile multipartFile) {
        try {
            List<StudentScore> studentScores = new ArrayList<StudentScore>();
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheetAt = workbook.getSheetAt(0);

            for (Row row : sheetAt) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                //从excel文件中获取学生成绩信息
                String scoreUUID = UUIDUtils.getUUID();
                String stuUUID = row.getCell(0).getStringCellValue();
                String semester = row.getCell(2).getStringCellValue();
                String subject = row.getCell(3).getStringCellValue();
                row.getCell(4).setCellType(CellType.STRING);
                String score = row.getCell(4).getStringCellValue();
                studentScores.add(new StudentScore(scoreUUID,stuUUID,semester,subject,score));
            }
            studentScores.forEach(parent -> {
                System.out.println("parent:" + parent.toString());
            });

            teacherMapper.importStudentScoreInfo(studentScores);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     *@Author lxl
     *@Description 根据教师编号查询班级信息列表
     *@Date 11:45 2019/4/11
     *@Param [teaUUID]
     *@return java.util.List<com.gx.community.teacher.pojo.ClassInfo>
     **/
    @Override
    public List<ClassInfo> queryClassInfoListByTeaUUID(String teaUUID) {
        return teacherMapper.queryClassInfoListByTeaUUID(teaUUID);
    }
}
