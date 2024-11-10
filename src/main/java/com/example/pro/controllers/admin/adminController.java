package com.example.pro.controllers.admin;

import com.example.pro.provider.controllerPathProvider;
import com.example.pro.dateframe.admin.adminUserFrame;
import com.example.pro.services.admin.adminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class adminController extends controllerPathProvider {
    adminController() {
        _path = "/admin";
    }

    @Autowired
    adminService _service;

    @RequestMapping({"", "/"})
    public ModelAndView home(HttpSession session) {
//        System.out.println(session.getAttribute("curUser"));
        ModelAndView mv = new ModelAndView(getPath("/admin"));
        mv.addObject("logUrl", session.getAttribute("curUser") == null ? "in" : "out");

        return mv;
    }

    @RequestMapping("/register")
    public String register() {
        return getPath("/register");
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public String createUser(adminUserFrame data) {
        int rst = _service.createUser(data);
        return redirect("");
    }

    @RequestMapping("/login")
    public String login() {
        return getPath("/login");
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return redirect("");
    }

    @RequestMapping(value = "/login_admin", method = RequestMethod.POST)
    public String login_admin(adminUserFrame data, HttpSession session) {
        adminUserFrame rst = _service.checkLogin(data);
        if(rst != null) {
            session.setAttribute("curUser", rst);
            session.setMaxInactiveInterval(60 * 60);
        }
        return redirect("");
    }
}
