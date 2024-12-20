package com.scene.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
/**
 * 返回格式
 */
public class ResultFormat {

    private String reqSucceed = "请求成功";
    private String reqFailed = "请求失败";
    private String serverError = "服务器内部错误";

    /**
     * 客户端错误 参数错误
     *
     * @param o
     * @return
     */
    public Map<String, Object> setFormatByNull(Object o) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 405);
        map.put("msg", reqFailed);
        map.put("data", o);
        return map;
    }

    /**
     * 客户端错误 参数错误 自带msg
     * @param o
     * @param msg
     * @return
     */

    public Map<String, Object> setFormatByNull(Object o, String msg) {
        Map<String, Object> map = setFormatByNull(o);
        map.put("msg", msg);
        return map;
    }

    /**
     * 请求成功 自带msg
     * @param o
     * @return
     */
    public Map<String, Object> setFormatBySucceed(Object o) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", reqSucceed);
        map.put("data", o);
        return map;
    }

    /**
     * 请求成功
     * @param o
     * @param msg
     * @return
     */

    public Map<String, Object> setFormatBySucceed(Object o, String msg) {
        Map<String, Object> map = setFormatBySucceed(o);
        map.put("msg", msg);
        return map;
    }

    /**
     * 服务器异常 自带msg
     * @param o
     * @return
     */
    public Map<String, Object> setFormatByFailed(Object o) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", serverError);
        map.put("data", o);
        return map;
    }

    /**
     * 服务器异常
     * @param o
     * @param msg
     * @return
     */
    public Map<String, Object> setFormatByFailed(Object o, String msg) {
        Map<String, Object> map = setFormatByFailed(o);
        map.put("msg", msg);
        return map;
    }
}
