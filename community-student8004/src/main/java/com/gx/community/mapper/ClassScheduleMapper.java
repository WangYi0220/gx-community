package com.gx.community.mapper;

import com.gx.community.pojo.ClassSchedule;
import org.apache.ibatis.annotations.Param;

public interface ClassScheduleMapper {
    ClassSchedule getClassScheduleByClassUUID(@Param("classUUID") String classUUID);
}
