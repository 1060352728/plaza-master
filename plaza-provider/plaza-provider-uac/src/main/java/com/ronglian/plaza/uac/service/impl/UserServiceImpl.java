package com.ronglian.plaza.uac.service.impl;

import com.ronglian.plaza.common.entity.uac.UserInfo;
import com.ronglian.plaza.uac.mapper.MenuInfoMapper;
import com.ronglian.plaza.uac.mapper.RoleInfoMapper;
import com.ronglian.plaza.uac.mapper.RoleMenuMapper;
import com.ronglian.plaza.uac.mapper.UserInfoMapper;
import com.ronglian.plaza.uac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author likui
 * @Classname: UserInfoServiceImpl
 * @Description: 用户service实现类
 * @create 2018-11-01 17:16
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    /**
     * 根据openid查询UserInfo对象
     * @param openId
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openId) {
        return userInfoMapper.findByOpenid(openId);
    }


    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Override
    public UserInfo findByUsername(String username) {
        //1：查询user对象
        UserInfo userInfo = userInfoMapper.findByUsername(username);
        return userInfo;
    }
}
