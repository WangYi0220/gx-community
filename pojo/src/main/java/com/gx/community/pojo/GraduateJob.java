package com.gx.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraduateJob {

    private String graUUID;//编号
    private String stuUUID; //学生编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graStartTime; //开始工作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graEndTime; //结束工作时间
    private String graCompany; //公司名称
    private String graPost; //公司职位
    private float pay; //薪资
    private String graAddress;//详细地址
}
