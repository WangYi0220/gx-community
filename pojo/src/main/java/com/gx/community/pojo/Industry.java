package com.gx.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 20:18
 * @description：
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Industry implements Serializable {
    private Integer industryID;
    private String industry;
}
