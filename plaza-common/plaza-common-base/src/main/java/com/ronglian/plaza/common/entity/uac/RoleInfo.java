package com.ronglian.plaza.common.entity.uac;

import lombok.Data;

import java.util.List;

/**
 * 角色实体
 */
@Data
public class RoleInfo {

    private Integer id;  //角色id

    private String roleNmae;  //角色名

    private String roleValue;  //角色

    private List<MenuInfo> menuInfoList;  //菜单
}
