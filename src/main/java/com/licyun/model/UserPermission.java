package com.licyun.model;

/**
 * Created by 李呈云
 * Description: 用户权限实体类
 * 2016/10/18.
 */
public class UserPermission {

    int id;
    String email;
    String permission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
