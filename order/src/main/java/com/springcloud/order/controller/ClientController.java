package com.springcloud.order.controller;

import com.springcloud.order.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 21:10
 * @Modified by:
 **/
@RestController
@Slf4j
public class ClientController {
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplateConfig restTemplateConfig;
    @GetMapping("/getProductMsg")
    public String getProductMsg(){


        //1.第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);
//      //第二种方式
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//        String response = restTemplate.getForObject(url,String.class);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        log.info("response={}", response);
        return response;
    }

}
