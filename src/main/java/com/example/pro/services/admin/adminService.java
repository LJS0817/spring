package com.example.pro.services.admin;

import com.example.pro.dao.admin.adminUserDao;
import com.example.pro.dateframe.admin.adminUserFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminService {
    @Autowired
    private adminUserDao _dao;

    public int createUser(adminUserFrame data) {
        return _dao.createUser(data);
    }

    public adminUserFrame checkLogin(adminUserFrame data) {
        return _dao.checkCorrectAdmin(data);
    }

    public List<adminUserFrame> getAdminList() {
        return _dao.getAdminList();
    }

    public boolean changeAdminAllowState(String id, String type) {
        return _dao.changeAdminAllowState(id, type);
    }

    public adminUserFrame updateUser(adminUserFrame data) {
        adminUserFrame u = _dao.updateUser(data);
        u.setName(data.getName());
        u.setGender(data.getGender());
        u.setPart(data.getPart());
        u.setType(data.getType());
        u.setMail(data.getMail());
        u.setPart(data.getPart());
        u.setPhone(data.getPhone());
        return u;
    }
}
