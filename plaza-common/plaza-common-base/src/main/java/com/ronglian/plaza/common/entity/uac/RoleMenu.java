package com.ronglian.plaza.common.entity.uac;

import lombok.Data;

/**
 * 角色对应的菜单
 */
@Data
public class RoleMenu {

    private Integer id; //主键

    private Integer roleId;  //角色id

    private Integer menuId;  //菜单id
}
