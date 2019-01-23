package com.springcloud.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.apigateway.exception.RateLimmitException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-23 20:04
 * @Modified by:
 **/
@Component
public class RateFilter  extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER -1;  //SERVLET_DETECTION_FILTER_ORDER优先级最小，优先级越小越早执行
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (!RATE_LIMITER.tryAcquire()){  //就是没有拿到令牌的话
            throw new RateLimmitException();
        }
        return null;
    }
}
