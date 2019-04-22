package com.gx.community.service;

import com.gx.community.mapper.IndustryMapper;
import com.gx.community.pojo.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 21:52
 * @description：行业操作
 * @modified By：
 */
@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryMapper industryMapper;

    //查询所有行业分类
    @Override
    public List<Industry> queryIndustry() {
        return industryMapper.queryIndustry();
    }

    //模糊查询行业分类
    @Override
    public List<Industry> queryIndustryLikeIndustry(String industry) {
        return industryMapper.queryIndustryLikeIndustry(industry);
    }
}
