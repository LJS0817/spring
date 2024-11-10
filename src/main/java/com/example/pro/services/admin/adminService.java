package com.example.pro.services.admin;

import com.example.pro.dao.admin.adminUserDao;
import com.example.pro.dateframe.admin.adminUserFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {
    @Autowired
    private adminUserDao _dao;

    public int createUser(adminUserFrame data) {
        return _dao.createUser(data);
    }

    public boolean checkLogin(adminUserFrame data) {
        return _dao.checkCorrectAdmin(data);
    }
}
