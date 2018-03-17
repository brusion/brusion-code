package com.demo.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 添加断路器功能
 *
 * @author brusion
 * @date 2018/3/17
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallBack")
    public String addService(){
        return restTemplate.getForEntity("http://DEMO-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallBack(){
        return "error";
    }
}
