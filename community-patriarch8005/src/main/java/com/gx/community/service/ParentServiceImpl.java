package com.gx.community.patriarch.service;

import com.gx.community.mapper.ParentMapper;
import com.gx.community.pojo.Parent;
import com.gx.community.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/9 8:50
 * @description 家长
 * @modified By:
 */
@Service
@Transactional
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentMapper parentMapper;

    /**
     *@Author lxl
     *@Description 家长登录
     *@Date 8:49 2019/4/9
     *@Param [parent]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @Override
    public Map<String, Object> login(Parent formData) {
        Map<String,Object> parent = parentMapper.login(formData);
        if(parent != null){
            return parent;
        } else {
            parent = new HashMap<>();
            String statusCode = "err";
            parent.put("statusCode",statusCode);
            return parent;
        }
    }

    /**
     *@Author lxl
     *@Description 修改默认密码
     *@Date 10:07 2019/4/9
     *@Param [formData]
     *@return void
     **/
    @Override
    public void updateDefaultPassword(Parent formData) {
        parentMapper.updateDefaultPassword(formData);
    }
}
