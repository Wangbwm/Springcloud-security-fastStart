package com.morewen.models.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.morewen.api.system.domain.SysRole;


import java.util.Set;

/**
* @author Wangbw
* @description 针对表【sys_role(角色信息表)】的数据库操作Service
* @createDate 2023-07-23 20:20:42
*/
public interface SysRoleService extends IService<SysRole> {

    Set<String> selectRolePermissionByUserId(Long userId);
}
