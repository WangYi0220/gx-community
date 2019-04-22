package com.gx.community.service;

import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.ClassScheduleMapper;
import com.gx.community.pojo.ClassSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/3 19:31
 * @description：课表
 * @modified By：
 */
@Service
@Transactional
public class ClassScheduleServiceImpl implements ClassScheduleService {
    @Autowired
    private ClassScheduleMapper classScheduleMapper;

    /**
     * 根据班级获取班级课表
     * @param classUUID
     * @return
     */
    @Override
    public ClassSchedule getClassScheduleByClassUUID(String classUUID) {
        return classScheduleMapper.getClassScheduleByClassUUID(classUUID);
    }

    /**
     * 添加课表
     * @param classSchedule
     */
    @Override
    public String addClassSchedule(ClassSchedule classSchedule) {
        String uuid = UUIDUtils.getUUID();
        classSchedule.setScheduleUUID(uuid);
        classScheduleMapper.addClassSchedule(classSchedule);
        return uuid;
    }

    /**
     * 修改课表
     * @param classSchedule
     */
    @Override
    public void updateClassSchedule(ClassSchedule classSchedule) {
        classScheduleMapper.updateClassSchedule(classSchedule);
    }
}
