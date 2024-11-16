package com.example.myspringlearn.beanfactory;

public interface BeanFactory {
    Object getBean(String name);
    Object getBean(String name, Object ... args);
}
