package com.gx.community.service;

import com.gx.community.mapper.StudentScoreMapper;
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

/**
 * @author shiloh
 * @Date Created in 2019/4/8 19:17
 * @description 学生成绩
 * @modified By:
 */
@Service
@Transactional
public class StudentScoreServiceImpl implements StudentScoreService {
    @Autowired
    private StudentScoreMapper studentScoreMapper;

    /**
     *@Author lxl
     *@Description 根据班级编号查询学生成绩基本信息
     *@Date 19:17 2019/4/8
     *@Param [classUUID]
     *@return org.springframework.http.ResponseEntity<org.springframework.core.io.InputStreamResource>
     **/
    @Override
    public ResponseEntity<InputStreamResource> downloadStudentScoreBaseInfoByClassUUID(String classUUID) {
        ResponseEntity<InputStreamResource> response = null;
        try {
            List<Student> scoreBaseInfo = studentScoreMapper.getStudentScoreBaseInfoByClassUUID(classUUID);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet xssfSheet = workbook.createSheet();
            XSSFRow titleRow = xssfSheet.createRow(0);
            titleRow.createCell(0).setCellValue("学生编号");
            titleRow.createCell(1).setCellValue("学生姓名");
            titleRow.createCell(2).setCellValue("学期");
            titleRow.createCell(3).setCellValue("科目");
            titleRow.createCell(4).setCellValue("成绩");
            scoreBaseInfo.forEach(item -> {
                System.out.println(item);
                int lastRowNum = xssfSheet.getLastRowNum();
                XSSFRow dataRow = xssfSheet.createRow(lastRowNum + 1);
                dataRow.createCell(1).setCellValue((String) item.getStuUUID());
                dataRow.createCell(2).setCellValue((String) item.getStuName());
            });
            String fileName = "成绩模板.xlsx";
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
}
