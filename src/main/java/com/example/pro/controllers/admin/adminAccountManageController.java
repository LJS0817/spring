package com.example.pro.controllers.admin;

import com.example.pro.dateframe.admin.adminUserFrame;
import com.example.pro.provider.controllerPathProvider;
import com.example.pro.services.admin.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/ls")
public class adminAccountManageController extends controllerPathProvider {
    adminAccountManageController() {
        _path = "/admin/ls";
    }

    @Autowired
    adminService _service;

    @RequestMapping({ "", "/" })
    public ModelAndView showList() {

        ModelAndView mv = new ModelAndView(getPath("/list"));
        mv.addObject("admin_ls", _service.getAdminList());

        return mv;
    }

    @RequestMapping("/allow")
    public String changeAllowState(@RequestParam String id, @RequestParam String type) {
        _service.changeAdminAllowState(id, type);

        return redirect("");
    }
}
