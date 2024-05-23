package com.pccomponentes.practice.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.pccomponentes.practice.exception.APIException;
import com.pccomponentes.practice.exception.APIRequestException;
import com.pccomponentes.practice.util.JWT;
import com.pccomponentes.practice.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");

        if(!StringUtils.hasLength(token)) {
            throw new APIException(APIRequestException.INVALIDATE_TOKEN);
        }

        try {
            JWT.parseJwt(token);
        } catch (Exception e) {
            throw new APIException(APIRequestException.INVALIDATE_TOKEN);
        }

        return true;
    }
}