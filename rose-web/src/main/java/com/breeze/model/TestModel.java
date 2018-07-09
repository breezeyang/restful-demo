package com.breeze.model;

public class TestModel {
    
    private Long userId;
    
    private String userName;
    
    private Integer age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }
    
    

    @Override
    public String toString() {
        return "TestModel [userId=" + userId + ", userName=" + userName + ", age=" + age + "]";
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    

}
