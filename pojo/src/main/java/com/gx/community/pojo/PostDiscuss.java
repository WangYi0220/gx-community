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
public class PostDiscuss implements Serializable {
    private String discussUUID;//评论编号
    private String postUUID;//帖子编号
    private String stuA;//学生编号A
    private String stuB;//学生编号B
    private String discussContent;//回复内容
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//时间
}
