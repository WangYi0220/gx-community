package com.gx.community.service;

import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.GraduateJobMapper;
import com.gx.community.pojo.GraduateJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/8 11:06
 * @description：毕业生就业
 * @modified By：
 */
@Service
public class GraduateJobServiceImpl implements GraduateJobService {

    @Autowired
    private GraduateJobMapper graduateJobMapper;

    @Override
    public List<Map<String, Object>> queryGraduateLikeStuName(String stuName) {
        return graduateJobMapper.queryGraduateLikeStuName(stuName);
    }

    @Override
    public List<Map<String, Object>> queryGraduateJobByStuUUID(String stuUUID) {
        return graduateJobMapper.queryGraduateJobByStuUUID(stuUUID);
    }

    @Override
    public String insertGraduateJob(GraduateJob graduateJob) {
        String uuid = UUIDUtils.getUUID();
        graduateJob.setGraUUID(uuid);
        graduateJobMapper.insertGraduateJob(graduateJob);
        return uuid;
    }

}
