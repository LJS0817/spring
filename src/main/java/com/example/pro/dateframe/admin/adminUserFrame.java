package com.example.pro.dateframe.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter @Setter
@ToString
public class adminUserFrame {
    private String uid;         //primary key
    private String id;          //관리자 ID
    private String pwd;         //관리자 password
    private String pwd_ag;      //관리자 password 재확인
    private String name;        //관리자 이름
    private String gender;      //관리자 성별
    private String part;        //관리자 부서
    private String type;        //관리자 직급
    private String mail;        //관리자 이메일
    private String phone;       //관리자 전화번호
    private String add_date;    //생성 날짜
    private String mod_date;    //수정 날짜

    public adminUserFrame(ResultSet rs) throws SQLException {
        if(rs == null) return;
        uid = rs.getString("uid");
        id = rs.getString("id");
        pwd = rs.getString("password");
//        pwd_ag = rs.getString("password_ag");
        name = rs.getString("name");
        gender = rs.getString("gender");
        part = rs.getString("part");
        type = rs.getString("type");
        mail = rs.getString("mail");
        phone = rs.getString("phone");
        add_date = rs.getString("add_date");
        mod_date = rs.getString("mod_date");
    }
}
