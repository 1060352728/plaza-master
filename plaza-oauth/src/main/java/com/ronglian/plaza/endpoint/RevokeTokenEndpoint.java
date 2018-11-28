package com.ronglian.plaza.endpoint;

import com.ronglian.plaza.uac.enums.LogoutResultEnum;
import com.ronglian.plaza.util.resultvo.ResultLogoutVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 清除token
 */
@FrameworkEndpoint
public class RevokeTokenEndpoint {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @RequestMapping(value = "/oauth/token", method= RequestMethod.DELETE)
    public @ResponseBody ResultLogoutVO revokeToken(String access_token){
        ResultLogoutVO resultLogoutVO = new ResultLogoutVO();
        if (consumerTokenServices.revokeToken(access_token)){
            resultLogoutVO.setCode(LogoutResultEnum.LOGOUT_SUCCESS.getCode());
            resultLogoutVO.setMsg(LogoutResultEnum.LOGOUT_SUCCESS.getMessage());
        }else {
            resultLogoutVO.setCode(LogoutResultEnum.LOGOUT_ERROR.getCode());
            resultLogoutVO.setMsg(LogoutResultEnum.LOGOUT_ERROR.getMessage());
        }
        return resultLogoutVO;
    }
}
