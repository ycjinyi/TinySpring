package com.example.myspringlearn.instantiationstrategy;

import com.example.myspringlearn.beandefinition.BeanDefinition;
import com.example.myspringlearn.beanexception.BeanException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition definition, String beanName,
                              Constructor<?> constructor, Object[] args) {
        Class<?> beanClass = definition.getBeanClass();
        try {
            if(args == null) {
                return beanClass.getDeclaredConstructor().newInstance();
            } else {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
        } catch (Exception e) {
            throw new BeanException("instantiate bean " + beanName + "failed!");
        }
    }
}
