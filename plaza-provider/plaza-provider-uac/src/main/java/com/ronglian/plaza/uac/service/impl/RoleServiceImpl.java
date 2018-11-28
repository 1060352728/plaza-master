package com.ronglian.plaza.uac.service.impl;

import com.ronglian.plaza.common.entity.uac.RoleInfo;
import com.ronglian.plaza.uac.mapper.RoleInfoMapper;
import com.ronglian.plaza.uac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public RoleInfo findById(Integer roleId) {
        return roleInfoMapper.findById(roleId);
    }
}
