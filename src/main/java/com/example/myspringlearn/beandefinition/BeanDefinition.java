package com.example.myspringlearn.beandefinition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BeanDefinition {
    private Class<?> beanClass;
}
