package com.scene.mapper;

import com.scene.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper {
    @Insert("INSERT INTO `scan_scenery`.`user_info` (`id`, `user_email`, `user_name`, `user_password`, `create_time`, `update_time`, `notarize_delete`, `delete_time`) " +
            "VALUES (#{id}, #{userEmail}, #{userName},#{userPassword}, #{createTime}, #{updateTime},#{notarizeDelete},#{deleteTime})")
    @Results({
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "notarizeDelete", column = "notarize_delete"),
            @Result(property = "deleteTime", column = "delete_time")
    })
    Integer insertUserInfo(UserInfo userInfo);

    @Select("select ui.id,ui.user_email,ui.user_name,ui.user_password,ui.create_time,ui.update_time,ui.notarize_delete,ui.delete_time from scan_scenery.user_info as ui where ui.user_email=#{userEmail} and ui.user_password=#{userPassword}")
    @Results({
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "notarizeDelete", column = "notarize_delete"),
            @Result(property = "deleteTime", column = "delete_time")
    })
    UserInfo selectUserInfoByEmail(UserInfo userInfo);

    @Select("select count(*) from scan_scenery.user_info where user_email =#{userEmail}")
    int existsUserInfoByEmail(String userEmail);
}
