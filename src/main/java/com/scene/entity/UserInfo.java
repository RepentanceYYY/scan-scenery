package com.scene.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private String id;
    private String userEmail;
    private String userName;
    private String userPassword;
    private Date createTime;
    private Date updateTime;
    private boolean notarizeDelete;
    private Date deleteTime;
    public UserInfo(){

    }

    public UserInfo(String id, String userEmail, String userName, String userPassword, Date createTime, Date updateTime, boolean notarizeDelete, Date deleteTime) {
        this.id = id;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.notarizeDelete = notarizeDelete;
        this.deleteTime = deleteTime;
    }
}
