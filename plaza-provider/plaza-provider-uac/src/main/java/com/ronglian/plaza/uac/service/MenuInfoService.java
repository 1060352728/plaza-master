package com.ronglian.plaza.uac.service;

import com.ronglian.plaza.common.entity.uac.MenuInfo;

import java.util.List;

public interface MenuInfoService {

    public List<MenuInfo> findMenus(Integer roleId);

}
