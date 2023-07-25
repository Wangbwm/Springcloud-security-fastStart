package com.morewen.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morewen.api.system.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Wangbw
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @createDate 2023-07-23 20:21:12
* @Entity generator.domain.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<String> selectMenuPermsByRoleId(Long roleId);

    List<String> selectMenuPermsByUserId(Long userId);
}




