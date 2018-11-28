package com.ronglian.plaza.uac.service.impl;

import com.ronglian.plaza.common.entity.uac.MenuInfo;
import com.ronglian.plaza.common.entity.uac.RoleMenu;
import com.ronglian.plaza.uac.mapper.MenuInfoMapper;
import com.ronglian.plaza.uac.mapper.RoleMenuMapper;
import com.ronglian.plaza.uac.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<MenuInfo> findMenus(Integer roleId) {
        List<RoleMenu> roleMenuList = roleMenuMapper.findByRoleId(roleId);
        List<Integer> menuIds = roleMenuList.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
        //4：根据关联表查询菜单
        List<MenuInfo> menuInfoList = menuInfoMapper.findByMenuIdIn(menuIds);
        return menuInfoList;
    }
}
