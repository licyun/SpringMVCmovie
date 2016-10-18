package com.licyun.dao;

import com.licyun.model.User;
import com.licyun.model.UserPermission;
import com.licyun.model.UserRole;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/18.
 */
public interface UserPermissionDao {

    String findPermissionsByEmail(String email);

    Long insertPermissions(UserPermission userPermission);

    Long updatePermissions(UserPermission userPermission);

    Long deletePermissionsByEmail(String email);
}
