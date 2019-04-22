package com.gx.community.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/1 15:15
 * @description：微信小程序登陆
 * @modified By：
 */
@Api(tags = "微信登陆")
@RestController
@RequestMapping("/wx/user")
public class WxMaUserController {
    @Autowired
    private WxMaService wxMaService;


    @ApiOperation("获取用户openID")
    @RequestMapping(value = "/login/{code}", method = RequestMethod.GET)
    public String login(@PathVariable("code") String code) {
        try {
            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);
            return JSON.toJSONString(sessionInfo);
        } catch (WxErrorException e) {
            e.printStackTrace();
            return "bad code";
        }
    }
}
