package com.scene.controller;

import com.scene.entity.ResultFormat;
import com.scene.entity.UserInfo;
import com.scene.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/UerManager")
public class UserController {
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private ResultFormat resultFormat;

    @PostMapping(value = "/sigNin")
    public Map<String, Object> addUser(@RequestBody UserInfo userInfo) {
        if (userInfo == null || StringUtils.isEmpty(userInfo.getUserName()) ||
                StringUtils.isEmpty(userInfo.getUserEmail()) || StringUtils.isEmpty(userInfo.getUserPassword())) {
            return resultFormat.setFormatByFailed(null);
        }
        UserInfo thenUser = iUserInfoService.addUser(userInfo);
        return thenUser == null ? resultFormat.setFormatByFailed(thenUser) : resultFormat.setFormatBySucceed(thenUser);
    }
}
