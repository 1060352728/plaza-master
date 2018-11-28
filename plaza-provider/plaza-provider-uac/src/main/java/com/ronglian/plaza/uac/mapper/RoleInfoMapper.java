package com.ronglian.plaza.uac.mapper;

import com.ronglian.plaza.common.entity.uac.RoleInfo;

public interface RoleInfoMapper {

    /**
     * 根据roleid查询role
     * @param roleId
     * @return
     */
    public RoleInfo findById(Integer roleId);

}
