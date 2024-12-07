package com.scene.mapper;

import com.scene.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

public interface UserInfoMapper {
    @Insert("INSERT INTO `scan_scenery`.`user_info` (`id`, `user_email`, `user_name`, `user_password`, `create_time`, `update_time`, `notarize_delete`, `delete_time`) " +
            "VALUES (#{id}, #{userEmail}, #{userName},#{userPassword}, #{createTime}, #{updateTime},#{notarizeDelete},#{deleteTime})")
    @Results({
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userEmail", column = "user_name"),
            @Result(property = "userName", column = "user_password"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "notarizeDelete", column = "notarize_delete"),
            @Result(property = "deleteTime", column = "delete_time")
    })
    Integer insertUserInfo(UserInfo userInfo);
}
