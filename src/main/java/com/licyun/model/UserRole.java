package com.licyun.model;

/**
 * Created by 李呈云
 * Description:用户角色实体类
 * 2016/10/18.
 */
public class UserRole {

    int id;
    String email;
    String roleName;
    int admin;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
