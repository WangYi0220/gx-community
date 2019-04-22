package com.gx.community.service;

import com.gx.community.mapper.PostTabMapper;
import com.gx.community.pojo.PostTab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/3 15:13
 * @description：帖子分类
 * @modified By：
 */
@Service
@Transactional
public class PostTabServiceImpl implements PostTabService {
    @Autowired
    private PostTabMapper postTabMapper;

    /**
     * 获取所有帖子分类
     * @return
     */
    @Override
    public List<PostTab> getPostTabList() {
        return postTabMapper.getPostTabList();
    }
}
