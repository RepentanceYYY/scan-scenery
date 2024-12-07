package com.scene.service.Impl;

import com.scene.entity.UserInfo;
import com.scene.mapper.UserInfoMapper;
import com.scene.service.IUserInfoService;
import com.scene.utils.DateTimeFactory;
import com.scene.utils.EncryptionTools;
import com.scene.utils.IdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserInfoService implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private IdFactory idFactory;
    @Autowired
    private DateTimeFactory dateTimeFactory;
    @Autowired
    private EncryptionTools encryptionTools;

    @Override

    public UserInfo addUser(UserInfo userInfo) {
        userInfo.setId(idFactory.getUUID());
        userInfo.setCreateTime(dateTimeFactory.getCurrentDate());
        userInfo.setUpdateTime(dateTimeFactory.getCurrentDate());
        String endPwd = encryptionTools.mD5ToString(userInfo.getUserPassword());
        userInfo.setUserPassword(endPwd);
        Integer insertResult = userInfoMapper.insertUserInfo(userInfo);
        return insertResult > 0 ? userInfo : null;
    }

    @Override
    public UserInfo selectUser(UserInfo userInfo) {
        String endPwd = encryptionTools.mD5ToString(userInfo.getUserPassword());
        userInfo.setUserPassword(endPwd);
        UserInfo curUserInfo = userInfoMapper.selectUserInfoByEmail(userInfo);
        if (curUserInfo != null && !StringUtils.isEmpty(curUserInfo.getId())) {
            curUserInfo.setUserPassword(null);
        }
        return curUserInfo;
    }

    @Override
    public Boolean existsUserByEmail(String userEmail) {
        int IsExists = userInfoMapper.existsUserInfoByEmail(userEmail);
        if (IsExists > 0) {
            return true;
        }
        return false;
    }
}
