package com.gec.controller;

import com.gec.entity.User;
import com.gec.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @GetMapping("findAll")
    public List<User> findAll() {
        return this.userService.getBaseMapper().selectList(null);
    }

    @GetMapping("findOne")
    public String findOne() {
        return "Hello";
    }

    /**
     * 登录控制层
     *
     * @param
     * @return
     */
    @GetMapping("login")
    public String login(String loginname,String password){

        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);

        System.out.println(loginname);
        System.out.println(password);

        try {
            User login = this.userService.login(user);
            return "true";

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    /**
     * Get请求版的注册
     * @param loginname
     * @param password
     * @param name
     * @param telephone
     * @return
     */

    @GetMapping("register")
    public String register(String loginname,String password,String name,String telephone) {

        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setName(name);
        user.setTelephone(telephone);


        try {
            this.userService.register(user);
            return "true";
        } catch (Exception e) {

            return e.getMessage();
        }
    }

}
