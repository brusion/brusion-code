package com.demo;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author brusion
 * @date 2018/8/8
 */
public class PatternResolverDemo {

    @Test
    public void getData() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();


        Resource resource[] = resolver.getResources("classpath*:com/demo/**/*.xml");
        assertNotNull(resource);

        for (Resource data : resource) {
            System.out.println(data.getDescription());

        }
    }
}
