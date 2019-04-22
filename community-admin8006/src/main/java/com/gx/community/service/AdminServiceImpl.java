package com.gx.community.service;

import com.gx.community.mapper.AdminMapper;
import com.gx.community.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/3 9:13
 * @description：管理员
 * @modified By：
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员登陆
     * @param admin
     * @return
     */
    @Override
    public Object login(Admin admin) {
        Admin login = adminMapper.login(admin);
        if (login == null) return 401;
        return login;
    }

    /**
     * 添加管理员
     * @param admin
     */
    @Override
    public void addAdmin(Admin admin) {
        adminMapper.addAdmin(admin);
    }

    /**
     * 删除管理员
     * @param adminUUID
     */
    @Override
    public void delAdmin(int adminUUID) {
        adminMapper.delAdmin(adminUUID);
    }
}
