package com.gx.community.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.mapper.ClassInfoMapper;
import com.gx.community.pojo.ClassInfo;
import com.gx.community.service.ClassInfoService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassInfoServiceImpl
 * @Description impl:ClassInfoServiceImpl
 * @Author lxl
 * @Date 2019/4/3
 * @Version 1.0
 **/
@Service
@Transactional
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     *@Author lxl
     *@Description 根据学院编号查询对应学院的班级信息列表,实现分页功能
     *@Date 19:32 2019/4/3
     *@Param [colID,pageNum]
     *@return java.util.List<com.gx.community.admin.pojo.ClassInfo>
     **/
    @Override
    public PageInfo<Map<String,Object>> queryClassInfoByColID(String colID,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Map<String,Object>> classInfoList = classInfoMapper.queryClassInfoByColID(colID);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(classInfoList);
        return pageInfo;
    }

    /**
     *@Author WangYi
     *@Description 添加班级辅导员
     **/
    @Override
    public void addClassTeacher(List<ClassInfo> params) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        ClassInfoMapper mapper = sqlSession.getMapper(ClassInfoMapper.class);
        params.forEach(item -> {
            mapper.addClassTeacher(item);
        });
        sqlSession.flushStatements();
        sqlSession.commit();
        sqlSession.close();
    }
}
