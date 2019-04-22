package com.gx.community.service;


import com.gx.community.pojo.Admin;

public interface AdminService {
    Object login(Admin admin);

    void addAdmin(Admin admin);

    void delAdmin(int adminUUID);
}
