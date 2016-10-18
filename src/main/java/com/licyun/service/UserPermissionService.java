package com.licyun.service;

import com.licyun.model.UserPermission;
import com.licyun.model.UserRole;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/18.
 */
public interface UserPermissionService {

    String findPermissionsByEmail(String email);

    Long insertPermissions(String email, String permission);

    Long updatePermissions(String email, String permission);

    Long deletePermissionsByEmail(String email);

}
