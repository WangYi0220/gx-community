package com.gx.community.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 8:34
 * @description：课程表
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ClassSchedule implements Serializable {
    private String scheduleUUID;//编号
    private String  classUUID;//班级编号
    private String  classSchedule;//课程表
}
