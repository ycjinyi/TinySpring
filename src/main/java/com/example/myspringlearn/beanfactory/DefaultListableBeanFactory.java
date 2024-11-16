package com.example.myspringlearn.beanfactory;

import com.example.myspringlearn.beandefinition.BeanDefinition;
import com.example.myspringlearn.beanregistry.BeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
    implements BeanRegistry {

    private Map<String, BeanDefinition> name2Definition = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition_(String name) {
        return name2Definition.get(name);
    }

    @Override
    public void registryBean(String name, BeanDefinition definition) {
        name2Definition.put(name, definition);
    }
}
