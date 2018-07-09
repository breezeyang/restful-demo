package com.breeze.service;

import java.util.List;

import com.breeze.model.User;

public interface IUserService {
    
    public List<User> queryAll();
    
    
    public int createUser(User user);
    
    public int createUserPart(User user, Integer tableId);
    
    public int createUserSeletive(User user);
    
    public List<User> queryUserByIds(List<Long> ids);
    
    public User findUserById(Long id);

}
