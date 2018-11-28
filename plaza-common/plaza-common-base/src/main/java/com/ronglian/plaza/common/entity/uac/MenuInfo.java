package com.ronglian.plaza.common.entity.uac;

import lombok.Data;

/**
 * 菜单实体
 */
@Data
public class MenuInfo {

    private Integer id;  //菜单id

    private String menuNmae;  //菜单名

    private String menuUrl;  //菜单路径

    private String menuCode; //菜单编码

}
