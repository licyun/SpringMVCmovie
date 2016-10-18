package com.licyun.service;

import com.licyun.model.UserRole;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/18.
 */
public interface UserRoleService {

    String findRolesByEmail(String email);

    int findAdminByEmail(String email);

    boolean findIsAdminByEmail(String email);

    Long insertRoles(String email, String roles);

    Long updateRoles(String email, String roles, int admin);

    Long deleteRolesByEmail(String email);
}
