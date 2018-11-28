package com.ronglian.plaza.uac.service;

import com.ronglian.plaza.common.entity.uac.UserInfo;

public interface UserService {

    /**
     * 根据openid查询UserInfo对象
     * @param openId
     * @return
     */
    public UserInfo findByOpenid(String openId);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    public UserInfo findByUsername(String username);
}
