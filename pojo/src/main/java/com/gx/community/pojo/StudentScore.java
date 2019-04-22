package com.gx.community.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * @ClassName StudentScore
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StudentScore implements Serializable {
    private String scoreUUID;//成绩编号
    private String stuUUID;//学生编号
    private String semester;//学期 如：2017-2018
    private String subject;//科目
    private String score;//分数
}
