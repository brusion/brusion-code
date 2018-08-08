package com.demo;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.web.context.support.ServletContextResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author brusion
 * @date 2018/8/8
 */
public class ResourceDemo {

    private String filePath = "/Users/shundaye/code_work/code_local/base/spring/spring-study-4x/01-ioc/01-ioc-resource/src/main/resources/file.txt";

    @Test
    public void writeData() throws IOException {
        WritableResource resource = new PathResource(filePath);
        OutputStream outputStream = resource.getOutputStream();
        outputStream.write("输出测试数据".getBytes());
        outputStream.close();


        InputStream inputStream = resource.getInputStream();
        ByteArrayOutputStream obs = new ByteArrayOutputStream();
        int i;
        while ((i = inputStream.read()) != -1) {
            obs.write(i);
        }
        System.out.println(obs.toString());

    }


    @Test
    public void getPath() {

        Resource resource2 = new ClassPathResource("resources/file.txt");
        String filename2 = resource2.getFilename();
        System.out.println(filename2);
    }


}
