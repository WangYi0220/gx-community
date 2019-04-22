package com.gx.community.service;

import com.gx.community.mapper.ClassScheduleMapper;
import com.gx.community.pojo.ClassSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 8:43
 * @description：课表
 * @modified By：
 */
@Service
@Transactional
public class ClassScheduleServiceImpl implements ClassScheduleService {
    @Autowired
    private ClassScheduleMapper classScheduleMapper;

    /**
     * 根据班级编号获取课程表
     * @author ：WangYi
     * @param classUUID
     * @return
     */
    @Override
    public ClassSchedule getClassScheduleByClassUUID(String classUUID) {
        return classScheduleMapper.getClassScheduleByClassUUID(classUUID);
    }
}
