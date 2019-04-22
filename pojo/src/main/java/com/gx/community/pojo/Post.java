package com.gx.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post implements Serializable {
    private String postUUID;//帖子编号
    private String postTitle;//帖子标题
    private int postTab;//帖子分类
    private String stuUUID;//学生编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//发帖时间
    private String postContent;//发帖内容
}
