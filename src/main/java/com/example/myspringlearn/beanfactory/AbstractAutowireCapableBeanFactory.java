package com.example.myspringlearn.beanfactory;

import com.example.myspringlearn.beandefinition.BeanDefinition;
import com.example.myspringlearn.beanexception.BeanException;
import com.example.myspringlearn.instantiationstrategy.CglibInstantiationStrategy;
import com.example.myspringlearn.instantiationstrategy.InstantiationStrategy;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;

@Setter
@Getter
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    @Override
    protected Object creatBean(String name, BeanDefinition beanDefinition, Object[] args) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> targetConstructor = null;
        int len = args == null ? 0: args.length;
        for(Constructor<?> cons: declaredConstructors) {
            if(cons.getParameterCount() == len) {
                targetConstructor = cons;
                break;
            }
        }
        if(targetConstructor == null) {
            throw new BeanException("no suitable constructor");
        }
        return instantiationStrategy.instantiate(beanDefinition, name, targetConstructor, args);
    }
}
