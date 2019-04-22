package com.gx.community.mapper;

import com.gx.community.pojo.Industry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author xyy
 *@Description mapper:IndustryMapper
 *@Date
 **/
public interface IndustryMapper {

    //查询所有行业分类
    List<Industry> queryIndustry();

    //模糊查询行业分类
    List<Industry> queryIndustryLikeIndustry(@Param("industry") String industry);

}
