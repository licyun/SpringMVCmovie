package com.licyun.service;

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
