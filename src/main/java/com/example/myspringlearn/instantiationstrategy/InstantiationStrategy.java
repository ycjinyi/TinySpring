package com.example.myspringlearn.instantiationstrategy;

import com.example.myspringlearn.beandefinition.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition definition, String beanName,
                       Constructor<?> constructor, Object[] args);
}
