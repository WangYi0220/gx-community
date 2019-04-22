package com.gx.community.controller;

import com.gx.community.common.utils.RedisUtils;
import com.gx.community.common.utils.SMS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/3 15:49
 * @description：工具接口
 * @modified By：
 */
@Api("工具")
@RestController
@RequestMapping("/utils")
public class UtilsController {
    @Autowired
    private RedisUtils redisUtils;
    private static final int TEMPLATE_ID = 143566;

    @ApiOperation("发送验证码")
    @RequestMapping(value = "/sendCode/{mobile}", method = RequestMethod.GET)
    public boolean registerCode(@PathVariable("mobile") String mobile) {
        redisUtils.del(mobile);
        String code = SMS.sendCode(mobile, TEMPLATE_ID);
        redisUtils.set(mobile, code, 300);
        Object o = redisUtils.get(mobile);
        System.out.println(o.toString());
        return true;
    }

}
