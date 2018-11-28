package com.ronglian.plaza.uac.mapper;

import com.ronglian.plaza.common.entity.uac.MenuInfo;

import java.util.List;

public interface MenuInfoMapper {

    /**
     * 根据菜单集合查询菜单
     * @param menuIds
     * @return
     */
    public List<MenuInfo> findByMenuIdIn(List<Integer> menuIds);
}
