package com.demo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author brusion
 * @date 2018/3/17
 */
@RestController
public class ServerController {

    Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b){

        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        Integer r = a+b;

        logger.info("add, host"+serviceInstance.getHost()+"  serverId: "+serviceInstance.getServiceId()+"   r"+r);
        return r;
    }
}
