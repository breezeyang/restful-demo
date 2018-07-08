package com.breeze.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor class User {
    
    private String name;

    private int age;

    private String tel;
    
    public User() {
        super();
    }
    
    public User(String name, int age, String tel) {
        super();
        this.age = age;
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}