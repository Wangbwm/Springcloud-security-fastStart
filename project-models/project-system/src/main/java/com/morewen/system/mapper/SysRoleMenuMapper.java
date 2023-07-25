package com.morewen.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.morewen.api.system.domain.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Wangbw
* @description 针对表【sys_role_menu(角色和菜单关联表)】的数据库操作Mapper
* @createDate 2023-07-23 20:21:20
* @Entity generator.domain.SysRoleMenu
*/
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

}




