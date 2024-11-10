package com.example.pro.controllers.admin;

import com.example.pro.dateframe.admin.adminUserFrame;
import com.example.pro.provider.controllerPathProvider;
import com.example.pro.services.admin.adminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class adminAccountEditController extends controllerPathProvider {
    adminAccountEditController() {
        _path = "/admin/edit";
    }

    @Autowired
    adminService _service;

    @RequestMapping({"/edit", "/edit/"})
    public String edit() {
        return getPath("/edit");
    }

    @RequestMapping(value = "/edit_admin", method = RequestMethod.POST)
    public String process(adminUserFrame data, HttpSession session) {
        adminUserFrame rst = _service.updateUser(data);
        System.out.println("====================");
        System.out.println(data);
        System.out.println(session.getAttribute("curUser"));
        System.out.println(rst);
        System.out.println("====================");
        if(rst != null) {
            session.setAttribute("curUser", rst);
            session.setMaxInactiveInterval(60 * 60);
        }
        return redirect("");
    }
}
