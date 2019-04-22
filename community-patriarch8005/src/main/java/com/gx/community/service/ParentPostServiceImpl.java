package com.gx.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.ParentPostMapper;
import com.gx.community.pojo.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 22:32
 * @description：就业贴操作
 * @modified By：
 */
@Service
public class ParentPostServiceImpl implements ParentPostService {

    @Autowired
    private ParentPostMapper parentPostMapper;

    //根据家长编号查看自己发布的就业贴
    @Override
    public PageInfo<Map<String, Object>> queryJobPostByParUUID(String parUUID,int nextPage) {
        PageHelper.startPage(nextPage,10);//1.设置pageHelper分页所需的参数
        List<Map<String,Object>> listData = parentPostMapper.queryJobPostByParUUID(parUUID);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(listData);//获取分页对象
        return pageInfo;
    }

    //家长删除自己发布的就业贴
    @Override
    public boolean deleteJobPostByJobUUID(String jobUUID) {
        parentPostMapper.deleteJobPostByJobUUID(jobUUID);
        return true;
    }

    @Override
    public boolean addPost(JobPost jobPost) {
        jobPost.setJobUUID(UUIDUtils.getUUID());
        parentPostMapper.addPost(jobPost);
        return true;
    }
}
