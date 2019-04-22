package com.gx.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 15:28
 * @description：管理员
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin implements Serializable {
    private int adminUUID;//管理员编号
    private String account;//账号
    private String passwords;//密码
    private String name;//姓名
    private String phone;//电话
    private String grade;//等级(0为最高，不可删，仅有一个)
}
