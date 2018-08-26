package com.best.consumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author brusion
 * @date 2018/8/25
 */
@FeignClient(name = "best-provide", fallback = UserRemote.UserRemoteHystrix.class)
public interface UserRemote {

    @RequestMapping("/index")
    String index();

    @Component
    public class UserRemoteHystrix implements UserRemote {
        @Override
        public String index() {
            return " hystrix data ： " + getClass().toString();
        }
    }

}
