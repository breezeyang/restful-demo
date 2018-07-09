package com.breeze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breeze.dao.UserDAO;
import com.breeze.model.User;
import com.breeze.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDAO userDAO;
    
    public List<User> queryAll() {
        List<User> userList = userDAO.queryAllUser();
        return userList;
    }

    
    public int createUser(User user) {
        int id = userDAO.insertUser(user);
        return id;
    }


    public int createUserPart(User user, Integer tableId) {
        int id = userDAO.insertUserPart(user, tableId);
        return id;
    }


    public int createUserSeletive(User user) {
        int id = userDAO.insertUserSeletive(user);
        return id;
    }


    public List<User> queryUserByIds(List<Long> ids) {
        
        return userDAO.queryUserByIds(ids);
    }


    @Override
    public User findUserById(Long id) {
        
        return userDAO.getUserById(id);
    }

}
