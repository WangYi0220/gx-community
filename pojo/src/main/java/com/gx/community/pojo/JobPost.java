package com.gx.community.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 20:14
 * @description：
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class JobPost implements Serializable {
    private String jobUUID;//就业贴编号
    private Integer industryID;//行业分类
    private String parUUID;//家长编号
    private String postName;//帖子标题
    private String orgName;//公司名称
    private String orgAddress;//工作地点
    private String orgRemark;//公司描述
    private String job;//岗位
    private String jobRequest;//工作要求
    private String jobRemark;//岗位描述
    private String salary;//薪水范围
    private String phone;//联系电话
    private String linkman;//联系人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;//创建时间
}
