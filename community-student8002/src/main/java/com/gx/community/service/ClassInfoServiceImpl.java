package com.gx.community.service;

import com.gx.community.mapper.ClassInfoMapper;
import com.gx.community.pojo.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ClassInfoServiceImpl
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@Service
@Transactional
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    /**
     *@Author lxl
     *@Description 根据classUUID查询对应的学生信息
     *@Date 15:15 2019/4/1
     *@Param [classUUID]
     *@return com.gx.community.pojo.ClassInfo
     **/
    @Override
    public ClassInfo queryByClassUUID(String classUUID) {
        System.out.println("我是A");
        return classInfoMapper.queryByClassUUID(classUUID);
    }


}
