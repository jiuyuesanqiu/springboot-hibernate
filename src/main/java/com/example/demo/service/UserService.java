package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * User业务逻辑
 */
@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name) {
        User user = null;
        try {
            user = userRepositoty.findByUserName(name);
        } catch (Exception e) {
        }
        return user;
    }

    public List<User> find() {
        List<User> list = null;
        try {
            list = userRepositoty.find();
        } catch (Exception e) {
        }
        return list;
    }

    public String deleteUserById(Integer id){
        int  a = userRepositoty.deleteUserById(id);
        return "chenggong";
    }

    public String queryUserById(Integer id ,String name){
        int a = userRepositoty.queryUserById(id,name);
        return "成功";
    }
}