package com.example.demo1.controller;


import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.demo1.userdao.userDao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {
    private final userDao userDao;
    @Autowired
    public helloController(userDao userDao){
        this.userDao = userDao;
    }
    @RequestMapping("/index.html")
    public void sayHello() {

    }
    @RequestMapping("/about.html")
    public void sayabout() {

    }
    @RequestMapping("/contact.html")
    public void saycontact() {

    }
    @RequestMapping("/shop.html")
    public void shop() {

    }
    @RequestMapping("/shop-single.html")
    public void single() {

    }
    @RequestMapping("/login.html")
    public void log() {

    }
    @RequestMapping ("/login")
    public String login(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password, Model model) {
        // 在这里可以使用 username 和 password 来处理登录逻辑
        // 例如，验证用户名和密码是否正确
        if (userDao.addUser(username, password)) {
            // 如果登录成功，设置提示消息
            String message = "添加成功！"; // 提示消息
            model.addAttribute("loginMessage", message);
        } else {
            // 如果登录失败，设置其他消息
            String errorMessage = "添加失败，请重试。"; // 错误消息
            model.addAttribute("loginMessage", errorMessage);
        }

        // 返回到登录页面
        return "login";
    }
}
