package com.gx.community.service;

import com.gx.community.mapper.ClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @ClassName ClassInfoServiceImpl
 * @Description impl:ClassInfoServiceImpl
 * @Author lxl
 * @Date 2019/4/8
 * @Version 1.0
 **/
@Service
@Transactional
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    /**
      *@Author lxl
      *@Description 根据班级编号查看对应班级的详情信息
      *@Date 10:31 2019/4/8
      *@Param [classUUID]
      *@return java.util.Map<java.lang.String,java.lang.Object>
      **/
    @Override
    public Map<String, Object> queryByClassUUID(String classUUID) {
        return classInfoMapper.queryByClassUUID(classUUID);
    }
}
