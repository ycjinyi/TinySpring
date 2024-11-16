package com.example.myspringlearn.instantiationstrategy;

import com.example.myspringlearn.beandefinition.BeanDefinition;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class CglibInstantiationStrategy implements  InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition definition, String beanName, Constructor<?> constructor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        Class<?> beanClass = definition.getBeanClass();
        enhancer.setSuperclass(beanClass);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(args == null) return enhancer.create();
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
