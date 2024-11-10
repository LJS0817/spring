package com.example.pro.provider;

public class controllerPathProvider {
    protected String _path = "";
    protected String getPath(String str) {
        return _path + str;
    }
    protected String redirect(String str) {
        return "redirect:" + getPath(str);
    }
}
