package com.gx.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 15:43
 * @description：老师
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher implements Serializable {
    private String teaUUID;//教师编号
    private String password;//密码
    private String teaName;//教师姓名
    private String telephone;//联系电话


}
