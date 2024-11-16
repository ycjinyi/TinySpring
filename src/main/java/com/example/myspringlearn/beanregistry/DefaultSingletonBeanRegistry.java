package com.example.myspringlearn.beanregistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{
    private final Map<String, Object> beanMap = new HashMap<>();
    @Override
    public Object getSingleton(String name) {
        return beanMap.get(name);
    }

    protected void putSingleton(String name, Object bean) {
        beanMap.put(name, bean);
    }
}
