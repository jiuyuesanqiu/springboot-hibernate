package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 
 * User控制层
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if(null != user)
            return user.getId()+"/"+user.getFirstName()+"/"+user.getSalary();
        else return "null";
    }

    @RequestMapping("/list")
    @ResponseBody
   public JSONObject showList(){
        List<User> list = userService.find();
       JSONObject jo = new JSONObject();
        if(list!=null){
            jo.put("code",0);
            jo.put("msg",true);
            jo.put("count",list.size());
            jo.put("data",list);
        }
       return jo;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String  deleteUserById(@RequestParam(value = "id")Integer id){
       return  userService.deleteUserById(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String queryUserById(@RequestParam(value = "id")Integer id,@RequestParam(value = "name")String  name){
        return userService.queryUserById(id,name);
    }
}