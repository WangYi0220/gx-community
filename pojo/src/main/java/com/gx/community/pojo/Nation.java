package com.gx.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Nation implements Serializable {
    private int nationID;//民族编号
    private String nationName;//民族名称
}
