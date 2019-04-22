package com.gx.community.service;

import com.gx.community.mapper.IndustryMapper;
import com.gx.community.pojo.Industry;
import com.gx.community.pojo.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 23:10
 * @description：行业操作
 * @modified By：
 */
@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryMapper industryMapper;

    @Override
    public boolean insertIndustry(Industry industry) {
        industryMapper.insertIndustry(industry);
        return true;
    }
}
