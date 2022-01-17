package com.example.emos.wx.service;

import com.example.emos.wx.db.pojo.TbUser;

import java.util.Set;

/**
 * @Author 张鑫宇
 * @Create 2022-01-09  12:28
 */
public interface UserService {

    /**
     * 注册用户
     * @param invitationCode  注册时的邀请码
     * @param code            临时授权字符串
     * @param nickname        微信昵称
     * @param photo           微信头像的url地址
     * @return userId          用户ID
     */
    public Integer insertUser(String invitationCode,String code,String nickname,String photo);

    /**
     * 根据userId，查询用户的权限
     * @param userId
     * @return
     */
    public Set<String> findIdByUserPermissions(Integer userId);


    /**
     * 根据userId，查询用户信息
     * @param userId
     * @return TbUser
     */
    public TbUser findAllByUserId(Integer userId);


    /**
     * 登录查询
     * @param code
     * @return userID
     */
    public Integer login(String code);
}