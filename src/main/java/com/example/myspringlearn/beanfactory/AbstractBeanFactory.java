package com.example.myspringlearn.beanfactory;

import com.example.myspringlearn.beandefinition.BeanDefinition;
import com.example.myspringlearn.beanexception.BeanException;
import com.example.myspringlearn.beanregistry.DefaultSingletonBeanRegistry;


import java.util.Objects;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    private Object doGetBean(String name, final Object[] args) {
        Object bean = getSingleton(name);
        if(bean != null) {
            return bean;
        }
        BeanDefinition definition = getBeanDefinition_(name);
        if(Objects.isNull(definition)) {
            throw new BeanException("bean names: " + name + "is not exist!");
        }
        bean = creatBean(name, definition, args);
        putSingleton(name, bean);
        return bean;
    }


    protected abstract Object creatBean(String name, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition_(String name);

}
