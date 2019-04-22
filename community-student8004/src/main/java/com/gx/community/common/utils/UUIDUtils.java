package com.gx.community.common.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid = uuid.replace("-", "");
    }
}
