package com.springcloud.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @program:
 * @description: 跨域配置
 * @author: Song
 * @create: Created in 2019-01-23 20:54
 * @Modified by:
 **/
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("*"));  //哪些原始域的cookie可以跨域访问
        config.setAllowedHeaders(Arrays.asList("*"));  //头
        config.setAllowedMethods(Arrays.asList("*"));  //方法
        config.setMaxAge(300l);  //缓存时间，在设置的时间段内对于相同的跨域请求不再检查
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);

    }

}
