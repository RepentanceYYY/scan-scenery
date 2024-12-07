package com.scene.service;

import com.scene.entity.UserInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

public interface IUserInfoService {
    UserInfo addUser(UserInfo userInfo);
    UserInfo selectUser(UserInfo userInfo);
    Boolean existsUserByEmail(String userEmail);
}
