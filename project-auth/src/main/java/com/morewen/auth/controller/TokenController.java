package com.morewen.auth.controller;

import com.morewen.api.system.model.LoginUser;
import com.morewen.auth.form.LoginBody;
import com.morewen.auth.form.RegisterBody;
import com.morewen.auth.service.SysLoginService;
import com.morewen.common.core.utils.AjaxResult;
import com.morewen.common.core.utils.JwtUtils;
import com.morewen.common.core.utils.StringUtils;
import com.morewen.common.security.auth.AuthUtil;
import com.morewen.common.security.service.TokenService;
import com.morewen.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * token 控制
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/auth")
public class TokenController
{
    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping("login")
    public AjaxResult login(@RequestBody LoginBody form)
    {
        // 用户登录
        LoginUser userInfo = sysLoginService.login(form.getUsername(), form.getPassword());
        // 获取登录token
        return AjaxResult.success(tokenService.createToken(userInfo));
    }

    @DeleteMapping("logout")
    public AjaxResult logout(HttpServletRequest request)
    {
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token))
        {
            String username = JwtUtils.getUserName(token);
            // 删除用户缓存记录
            AuthUtil.logoutByToken(token);
            // 记录用户退出日志
            sysLoginService.logout(username);
        }
        return AjaxResult.success();
    }

    @PostMapping("refresh")
    public AjaxResult refresh(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            // 刷新令牌有效期
            tokenService.refreshToken(loginUser);
            return AjaxResult.success();
        }
        return AjaxResult.success();
    }

    @PostMapping("register")
    public AjaxResult register(@RequestBody RegisterBody registerBody)
    {
        // 用户注册
        sysLoginService.register(registerBody.getUsername(), registerBody.getPassword());
        return AjaxResult.success();
    }
}
