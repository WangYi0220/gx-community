package com.gx.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class College implements Serializable {
    private int colID;//学院编号
    private String colName;//学院名称
}
