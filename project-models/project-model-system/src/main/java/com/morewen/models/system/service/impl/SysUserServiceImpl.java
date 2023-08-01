package com.morewen.models.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.morewen.common.core.constant.UserConstants;
import com.morewen.common.core.utils.StringUtils;
import com.morewen.api.system.domain.SysUser;
import com.morewen.models.system.mapper.SysUserMapper;
import com.morewen.models.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Wangbw
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2023-07-23 20:19:31
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {
    @Autowired
    SysUserMapper userMapper;
    @Override
    public boolean checkUserNameUnique(SysUser sysUser) {
        Long userId = StringUtils.isNull(sysUser.getUserId()) ? -1L : sysUser.getUserId();
        SysUser info = userMapper.checkUserNameUnique(sysUser.getUserName());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public boolean registerUser(SysUser sysUser) {
        return userMapper.insert(sysUser) > 0;
    }

    @Override
    public SysUser getUserByUserName(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",username);
        return userMapper.selectOne(wrapper);
    }
}




