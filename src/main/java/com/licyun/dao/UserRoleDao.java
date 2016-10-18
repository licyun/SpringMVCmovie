package com.licyun.dao;

import com.licyun.model.UserRole;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/18.
 */
public interface UserRoleDao {

    String findRolesByEmail(String email);

    int findAdminByEmail(String email);

    Long insertRoles(UserRole userRole);

    Long updateRoles(UserRole userRole);

    Long deleteRolesByEmail(String email);
}
