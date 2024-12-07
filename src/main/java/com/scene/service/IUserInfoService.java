package com.scene.service;

import com.scene.entity.UserInfo;
import org.springframework.stereotype.Service;

public interface IUserInfoService {
    UserInfo addUser(UserInfo userInfo);
}
