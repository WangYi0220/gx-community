package com.gx.community.service;

import com.gx.community.pojo.ClassSchedule;

public interface ClassScheduleService {
    ClassSchedule getClassScheduleByClassUUID(String classUUID);

    String addClassSchedule(ClassSchedule classSchedule);

    void updateClassSchedule(ClassSchedule classSchedule);
}
