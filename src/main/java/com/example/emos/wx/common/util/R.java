package com.example.emos.wx.common.util;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: emos-wx-api
 * @Description: 统一数据返回格式
 * @Author: 张鑫宇
 * @Create: 2022-01-04 22:11
 **/
public class R extends HashMap<String, Object> {

    public R() {
        put("code", HttpStatus.SC_OK);
        put("msg", "success");
    }

    /**
     * 方便链式调用
     *
     * @param key
     * @param value
     * @return
     */
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    //封装返回成功的类
    public static R success() {
        return new R();
    }

    public static R success(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R success(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    //封装返回失败的类
    public static R error(Integer code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员！");
    }


}