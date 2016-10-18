package com.licyun.model;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/18.
 */
public class UserPR {

    String email;
    String name;
    String password;
    String userRole;
    String userPermission;

    public UserPR() {
    }

    public UserPR(String email, String name, String password, String userRole, String userPermission) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.userRole = userRole;
        this.userPermission = userPermission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }
}
