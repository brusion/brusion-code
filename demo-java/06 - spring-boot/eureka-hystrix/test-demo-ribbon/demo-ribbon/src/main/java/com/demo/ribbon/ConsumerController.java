package com.demo.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author brusion
 * @date 2018/3/17
 */
@RestController
public class ConsumerController {

//    @Autowired
//    RestTemplate restTemplate;
//
//    //DEMO-SERVICE：为serverId的全大写
//    @RequestMapping(value = "add",method = RequestMethod.GET)
//    public String add(){
//        return restTemplate.getForEntity("http://DEMO-SERVICE/add?a=10&b=22",String.class).getBody();
//    }

    @Autowired
    ConsumerService service;

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(){
        return service.addService();
    }


}
