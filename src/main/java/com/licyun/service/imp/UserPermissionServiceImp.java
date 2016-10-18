package com.licyun.service.imp;

import com.licyun.dao.UserPermissionDao;
import com.licyun.model.UserPermission;
import com.licyun.model.UserRole;
import com.licyun.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/18.
 */
@Service
public class UserPermissionServiceImp implements UserPermissionService{

    @Autowired
    private UserPermissionDao userPermissionDao;

    public String findPermissionsByEmail(String email){
        return userPermissionDao.findPermissionsByEmail(email);
    }

    public Long insertPermissions(String email, String permission){
        UserPermission userPermission = new UserPermission();
        userPermission.setEmail(email);
        userPermission.setPermission(permission);
        return userPermissionDao.insertPermissions(userPermission);
    }

    public Long updatePermissions(String email, String permission){
        UserPermission userPermission = new UserPermission();
        userPermission.setEmail(email);
        userPermission.setPermission(permission);
        return userPermissionDao.updatePermissions(userPermission);
    }

    public Long deletePermissionsByEmail(String email){
        return userPermissionDao.deletePermissionsByEmail(email);
    }
}
