package com.atguigu.gulimall.cart.interceptor;


import com.atguigu.common.constant.AuthServerConstant;
import com.atguigu.common.constant.CartConstant;
import com.atguigu.common.vo.MemberResponseVo;
import com.atguigu.gulimall.cart.to.UserInfoTo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;


public class CartInterceptor implements HandlerInterceptor {

    public static ThreadLocal<UserInfoTo> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserInfoTo userInfo = new UserInfoTo();
        HttpSession session = request.getSession();
        MemberResponseVo member = (MemberResponseVo) session.getAttribute(AuthServerConstant.LOGIN_USER);
        if(member!=null){
            //用户登录
            userInfo.setUserId(member.getId());
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //user-key
            String name = cookie.getName();
            if(name.equals(CartConstant.TEMP_USER_COOKIE_NAME)){
                userInfo.setUserKey(cookie.getValue());
            }
        }

        //如果没有临时用户，创建一个临时用户
        if(StringUtils.isEmpty(userInfo.getUserKey())){
            String s = UUID.randomUUID().toString();
            userInfo.setUserKey(s);
            userInfo.setTempUser(true);
        }

        //目标方法执行之前
        threadLocal.set(userInfo);
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserInfoTo userInfoTo = threadLocal.get();
        if(userInfoTo.isTempUser()){
            //持续延长临时用户的过期时间
            Cookie cookie = new Cookie(CartConstant.TEMP_USER_COOKIE_NAME, userInfoTo.getUserKey());
            cookie.setDomain("gulimall.com");
            cookie.setMaxAge(CartConstant.TEMP_USER_COOKIE_TIMEOUT);
            response.addCookie(cookie);
        }
    }
}
