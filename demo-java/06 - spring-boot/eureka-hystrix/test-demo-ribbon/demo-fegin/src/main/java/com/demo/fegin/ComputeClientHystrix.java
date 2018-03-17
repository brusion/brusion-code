package com.demo.fegin;

import org.springframework.stereotype.Component;

/**
 * 添加断路器
 *
 * @author brusion
 * @date 2018/3/17
 */
@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(Integer a, Integer b) {
        return -1;
    }
}
