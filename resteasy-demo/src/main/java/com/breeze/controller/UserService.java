package com.breeze.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.breeze.model.User;


@Path("userservice") // 服务路径
public class UserService {
    /**
     * 初始化三个用户数据，存入map中，key为用户id，value为用户对象
     */
    static Map<Integer, User> userMap = new HashMap<>();
    static {
        User user1 = new User("Lee", 24, "138***");
        userMap.put(1, user1);
        User user2 = new User("Cathy", 25, "188***");
        userMap.put(2, user2);
        User user3 = new User("Aaron", 26, "186***");
        userMap.put(3, user3);
    }

    /**
     * 获取指定id的用户
     * 
     * @param id
     * @return
     */
    @GET
    @Path("user/{id}") // 具体服务的路径, id是入参
    @Produces("application/json") // 返回的格式
    public User getById(@PathParam("id") Integer id) {
        return (User) userMap.get(id);
    }

    /**
     * 以json格式返回所有用户
     * 
     * @return
     */
    @GET
    @Path("users")
    @Produces("application/json")
    public List<User> getUsers() {
        List<User> userList = new ArrayList<User>();
        for (Entry<Integer, User> user : userMap.entrySet()) {
            userList.add(user.getValue());
        }
        return userList;
    }
}