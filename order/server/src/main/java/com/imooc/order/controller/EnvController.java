package com.imooc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 廖师兄
 * 2018-01-21 21:57
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class EnvController {

    @Value("${test}")
    private String test;

    @GetMapping("/print")
    public String print() {
        return test;
    }
}
