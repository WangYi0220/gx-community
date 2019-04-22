package com.gx.community.mapper;

import com.gx.community.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin login(Admin admin);

    void addAdmin(Admin admin);

    void delAdmin(@Param("adminUUID") int adminUUID);
}
