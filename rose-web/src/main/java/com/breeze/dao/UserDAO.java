package com.breeze.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.jade.annotation.ShardBy;

import com.breeze.model.User;

@DAO
public interface UserDAO {

    @SQL("select id, name, age from user")
    public List<User> queryAllUser();
    
    @ReturnGeneratedKeys
    @SQL("insert into user (id, name, age) value(:u.id, :u.name, :u.age)")
    public int insertUser(@SQLParam("u") User user);
    
    
    @ReturnGeneratedKeys
    @SQL("insert into user_##(:tid) (id, name, age) value(:u.id, :u.name, :u.age)")
    public int insertUserPart(@SQLParam("u") User user, @SQLParam("tid")Integer tableId);
    
    @ReturnGeneratedKeys
    @SQL("insert into user (id, name, age) value(:u.id, #if( :u.name == null ) { \"test\"}, :u.age)")
    public int insertUserSeletive(@SQLParam("u") User user);
    
    @SQL("select id, name, age from user where id in (:ids)")
    public List<User> queryUserByIds(@SQLParam("ids")List<Long> ids);
    
    @SQL("select id, name , age from user where id  =  :id limit 1")
    public User getUserById(@ShardBy @SQLParam("id") Long id);
}
