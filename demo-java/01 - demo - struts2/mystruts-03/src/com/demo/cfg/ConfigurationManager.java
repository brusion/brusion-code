package com.demo.cfg;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置文件工具类：内部封装了配置文件属性
 *
 * @author brusion
 * @date 2018/4/1
 */
public class ConfigurationManager {

    private Map<String, ActionMapping> configurationMapping;

    public ConfigurationManager() {
        configurationMapping = new HashMap<>();
        init();
    }

    private void init() {

        try {
            InputStream inputStream = ConfigurationManager.class.getResourceAsStream("/mystruts.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);

            List<Element> list = document.selectNodes("//action");
            for (Element element : list) {
                ActionMapping actionMapping = new ActionMapping();
                String name = element.attributeValue("name");
                actionMapping.setClassName(name);

                String method = element.attributeValue("method");
                if (method == null || method.length() ==0){
                    method="execute";
                }
                actionMapping.setMethod(method);
                actionMapping.setClassName(element.attributeValue("class"));

                List<Element> resultList = element.elements("result");
                Map<String, Result> results = new HashMap<>();
                for (Element elme : resultList) {
                    Result result = new Result();
                    result.setName(elme.attributeValue("name"));
                    result.setType(elme.attributeValue("type"));
                    result.setPage(elme.getText().trim());

                    results.put(result.getName(), result);
                }
                actionMapping.setResults(results);

                configurationMapping.put(name, actionMapping);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Map<String, ActionMapping> getConfigurationMapping() {
        return configurationMapping;
    }
}