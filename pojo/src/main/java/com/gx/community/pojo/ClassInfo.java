package com.gx.community.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName ClassInfo
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ClassInfo implements Serializable {
    private String classUUID;//班级编号
    private int colID;//学院编号
    private String grade;//年级 如:2017
    private String className;//班级名字
    private String teaUUID;//辅导员编号
}
