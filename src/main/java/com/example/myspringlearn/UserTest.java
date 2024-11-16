package com.example.myspringlearn;

public class UserTest {
    private final String name;
    public UserTest(String name) {
        this.name = name;
    }

    public void song() {
        System.out.println(name + "is singing");
    }
}
