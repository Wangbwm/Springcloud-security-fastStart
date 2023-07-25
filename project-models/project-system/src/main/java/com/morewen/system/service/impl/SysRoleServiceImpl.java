package com.morewen.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.morewen.common.core.utils.StringUtils;
import com.morewen.api.system.domain.SysRole;
import com.morewen.system.mapper.SysRoleMapper;
import com.morewen.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @author Wangbw
* @description 针对表【sys_role(角色信息表)】的数据库操作Service实现
* @createDate 2023-07-23 20:20:42
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<SysRole> perms = sysRoleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }
}




