package com.example.myspringlearn.beanregistry;

import com.example.myspringlearn.beandefinition.BeanDefinition;

public interface BeanRegistry {
    void registryBean(String name, BeanDefinition definition);
}
