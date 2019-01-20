package com.springcloud.product.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 21:08
 * @Modified by:
 **/
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product msg";
    }
}
