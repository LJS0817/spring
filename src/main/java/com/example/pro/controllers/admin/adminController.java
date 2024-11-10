package com.example.pro.controllers.admin;

import com.example.pro.provider.controllerPathProvider;
import com.example.pro.dateframe.admin.adminUserFrame;
import com.example.pro.services.admin.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class adminController extends controllerPathProvider {
    adminController() {
        _path = "/admin";
    }

    @Autowired
    adminService _service;

    @RequestMapping({"", "/"})
    public String home(Model model) {
        model.addAttribute("logUrl", "in");
        return getPath("/admin");
    }

    @RequestMapping("/register")
    public String register() {
        return getPath("/register");
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public String createUser(adminUserFrame data) {
//        System.out.println(data);
        int rst = _service.createUser(data);
        return "redirect:" + getPath("");
    }

    @RequestMapping("/login")
    public String login() {
        return getPath("/login");
    }

    @RequestMapping(value = "/login_admin", method = RequestMethod.POST)
    public String login_admin(adminUserFrame data) {
        if(_service.checkLogin(data)) {

        }
        return "redirect:" + getPath("");
    }

}
