package com.breeze.controllers;

import java.util.List;

import javax.annotation.Resource;

import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import com.breeze.model.User;
import com.breeze.service.IUserService;

@Path("/user/")
public class UserController extends BaseController {
    
    @Resource( name = "userService" )
    IUserService userService;
    
    @Get("get_all_user")
    public String getAllUser() {
        List<User> userList = userService.queryAll();
        return "@json:" + this.success(userList);
    }
    
    @Get("create_user/{name:[a-z|A-Z|0-9]+}/{age:[0-9]+}")
    public String createUser(@Param("name") String name, @Param("age")Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int createUser = userService.createUser(user);
        
        return "@json:" + createUser;
    }
    
    @Get("create_user_part/{name:[a-z|A-Z|0-9]+}/{age:[0-9]+}/{tableid:[1]}")
    public String createUserPart(@Param("name") String name, @Param("age")Integer age, @Param("tableid")Integer tableId) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int createUser = userService.createUserPart(user, tableId);
        
        return "@json:" + createUser;
    }
    
    
    @Get("create_user_seletive/{name:[a-z|A-Z|0-9]+}/{age:[0-9]+}")
    public String createUserSeletive(@Param("name") String name, @Param("age")Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int createUser = userService.createUserSeletive(user);
        
        return "@json:" + createUser;
    }
    
    @Get("get_user_by_ids")
    public String getUserByIds(@Param("ids") List<Long> ids) {
        
        List<User> userList = userService.queryUserByIds(ids);
        
        return "@json:" + this.success(userList);
    }

    @Get("get_user_by_id")
    public String getUserById(@Param("id")Long id) {
        User user = userService.findUserById(id);
        return "@json:" + this.success(user);
    }
}
