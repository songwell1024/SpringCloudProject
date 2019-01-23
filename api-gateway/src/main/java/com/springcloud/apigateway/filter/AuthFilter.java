package com.springcloud.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.apigateway.constant.RedisConstant;
import com.springcloud.apigateway.util.CookieUtil;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @program:
 * @description: 权限拦截
 * @author: Song
 * @create: Created in 2019-01-23 19:39
 * @Modified by:
 **/
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //从url参数获取,也可以从cookie, header里获取
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            /**
             * /order/create 只能买家访问（cookie中有openid）
             * /order/finish 只能卖家访问(cookie中有token,并且对应Redis中的值)
             * /product/list 都能访问
             */
            if ("/order/order/create".equals(request.getRequestURI())){
                Cookie cookie = CookieUtil.get(request, "openid");
                if (cookie == null || StringUtils.isEmpty(cookie.getValue())){
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
                }
            }

            if ("/order/order/create".equals(request.getRequestURI())){
                Cookie cookie = CookieUtil.get(request, "token");
                if (cookie == null || StringUtils.isEmpty(cookie.getValue()) ||
                        StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
                }
            }
        }
        return null;
    }
}
