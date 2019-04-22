package com.gx.community.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 15:22
 * @description：家长
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Parent implements Serializable {
    private String parUUID;//家长编号
    private String password;//密码
    private String parName;//家长姓名
    private String telephone;//联系电话
    private String employer;//工作单位
}
