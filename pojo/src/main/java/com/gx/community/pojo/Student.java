package com.gx.community.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * @ClassName Student
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Student implements Serializable {
    private String stuUUID;//学生编号
    private String stuHeadImg;//学生头像
    private String password;//密码
    private String stuNO;//学号
    private String classUUID;//班级编号
    private String stuName;//学生姓名
    private String sex;//学生性别
    private String nationID;//民族编号
    private String accountLoc;//户口所在地
    private String telephone;//联系电话
    private String idCard;//身份证号
    private String polStatus;//0：群众 1：共青团员 2：党员 3：其他
    private String accountType;//户口类型 0：城镇户口 1：农村户口
    private String familyAdd;//家庭地址
    private String graSchool;//毕业中学
    private String eduLevel;//文化程度 0：中专 1：高中
}
