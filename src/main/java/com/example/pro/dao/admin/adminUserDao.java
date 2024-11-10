package com.example.pro.dao.admin;

import com.example.pro.dateframe.admin.adminUserFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Component
public class adminUserDao {
    private final String superId = "admin";

    @Autowired
    private JdbcTemplate _db;

    private PasswordEncoder _encoder = new BCryptPasswordEncoder();

    private boolean hasUser(String id) {
        int rst = _db.queryForObject("SELECT COUNT(*) FROM admin_user WHERE id = ?", Integer.class, id);
        return rst != 0;
    }

    public int createUser(adminUserFrame data) {
        if(hasUser(data.getId())) return -1;

        String[] args = {
                data.getId().equals(superId) ? "Y" : "N",
                data.getId(),
                _encoder.encode(data.getPwd()),
                data.getName(),
                data.getGender(),
                data.getPart(),
                data.getType(),
                data.getMail(),
                data.getPhone()
        };

        int rst = _db.update("INSERT INTO admin_user VALUES(0, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())", args);

        return rst;
    }

    public boolean checkCorrectAdmin(adminUserFrame data) {
        if(!hasUser(data.getId())) return false;
        List<adminUserFrame> ls = _db.query("SELECT * FROM admin_user WHERE id=?", (rs, rowNum) -> new adminUserFrame(rs), data.getId());
        if(ls.size() != 1 || !_encoder.matches(data.getPwd(), ls.getFirst().getPwd())) {
            ls.clear();
            return false;
        }
        return true;
    }
}
