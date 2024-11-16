package com.example.myspringlearn;

import com.example.myspringlearn.beandefinition.BeanDefinition;
import com.example.myspringlearn.beanfactory.DefaultListableBeanFactory;
import com.example.myspringlearn.instantiationstrategy.SimpleInstantiationStrategy;

public class ApiTest {
    public static void main(String[] args) {
        BeanDefinition definition = new BeanDefinition(UserTest.class);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
        beanFactory.registryBean("UserTest", definition);

        UserTest bean = (UserTest) beanFactory.getBean("UserTest", "张三");
        bean.song();
    }
}
