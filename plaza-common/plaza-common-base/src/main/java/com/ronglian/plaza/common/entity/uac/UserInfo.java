package com.ronglian.plaza.common.entity.uac;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author likui
 * @Classname: UserInfo
 * @Description: 用户实体类
 * @create 2018-11-01 17:04
 **/
@Data
public class UserInfo {

    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role; //1买家   2卖家

    private Timestamp createTime;

    private Timestamp updateTime;

    private RoleInfo roleInfo;

}
