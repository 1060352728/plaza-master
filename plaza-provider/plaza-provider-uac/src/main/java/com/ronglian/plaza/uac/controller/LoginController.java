package com.ronglian.plaza.uac.controller;

import com.ronglian.plaza.common.entity.uac.UserInfo;
import com.ronglian.plaza.omc.vo.ResultVO;
import com.ronglian.plaza.omc.vo.ResultVOUtil;
import com.ronglian.plaza.uac.enums.LoginResultEnum;
import com.ronglian.plaza.uac.enums.RoleEnum;
import com.ronglian.plaza.uac.service.UserService;
import com.ronglian.plaza.util.common.CookieUtil;
import com.ronglian.plaza.util.constant.CookieConstant;
import com.ronglian.plaza.util.constant.RedisConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author likui
 * @Classname: LoginController
 * @Description: 用户登录
 * @create 2018-11-01 17:14
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 买家登录
     * @param openid
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response){
        //1:使用openid和数据库对比
        UserInfo userInfo = userService.findByOpenid(openid);
        if(userInfo == null){
            return ResultVOUtil.error(LoginResultEnum.LOGIN_FAIL.getCode(),LoginResultEnum.LOGIN_FAIL.getMessage());
        }
        //2：判断角色
        if(RoleEnum.BUYER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(LoginResultEnum.ROLE_ERROR.getCode(),LoginResultEnum.ROLE_ERROR.getMessage());
        }
        //3：将角色存入cookie中
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);
        return ResultVOUtil.success(userInfo);
    }

    /**
     * 卖家登录
     * @param openid
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response, HttpServletRequest request){
        //1:使用openid和数据库对比
        UserInfo userInfo = userService.findByOpenid(openid);
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie!=null){
            String redisValues = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue()));
            if(StringUtils.isNotBlank(redisValues)){
                return ResultVOUtil.success(userInfo);
            }
        }
        if(userInfo == null){
            return ResultVOUtil.error(LoginResultEnum.LOGIN_FAIL.getCode(),LoginResultEnum.LOGIN_FAIL.getMessage());
        }
        //2：判断角色
        if(RoleEnum.SELLER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(LoginResultEnum.ROLE_ERROR.getCode(),LoginResultEnum.ROLE_ERROR.getMessage());
        }
        //3:将登录信息存放在redis中
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.EXPIRE;//过期时间
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),openid,expire,TimeUnit.SECONDS);
        //4：将角色存入cookie中,存放token的uuid,过期时间2h
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
        return ResultVOUtil.success(userInfo);
    }
}
