package com.scene.controller;

import com.scene.entity.ResultFormat;
import com.scene.entity.UserInfo;
import com.scene.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
        String msg;
        if (userInfo == null || StringUtils.isEmpty(userInfo.getUserName()) ||
                StringUtils.isEmpty(userInfo.getUserEmail()) || StringUtils.isEmpty(userInfo.getUserPassword())) {
            return resultFormat.setFormatByNull(null);
        }
        Boolean isExists = iUserInfoService.existsUserByEmail(userInfo.getUserEmail());
        if (isExists) {
            msg = "邮箱已注册";
            return resultFormat.setFormatBySucceed(null, msg);
        }
        UserInfo thenUser = iUserInfoService.addUser(userInfo);
        return thenUser == null ? resultFormat.setFormatByFailed(thenUser) : resultFormat.setFormatBySucceed(thenUser);
    }

    @GetMapping(value = "/Login")
    public Map<String, Object> getUserInfo(@RequestBody UserInfo userInfo) {
        String msg = "";
        if (userInfo == null || StringUtils.isEmpty(userInfo.getUserEmail()) || StringUtils.isEmpty(userInfo.getUserPassword())) {
            return resultFormat.setFormatByNull(null);
        }
        UserInfo curUserInfo = iUserInfoService.selectUser(userInfo);

        msg = ((curUserInfo == null) ? "邮箱或密码错误" : "用户查询成功");
        return resultFormat.setFormatBySucceed(curUserInfo, msg);

    }
}
