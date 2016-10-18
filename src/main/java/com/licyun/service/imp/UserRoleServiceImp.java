package com.licyun.service.imp;

import com.licyun.dao.UserRoleDao;
import com.licyun.model.User;
import com.licyun.model.UserRole;
import com.licyun.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/18.
 */
@Service
public class UserRoleServiceImp implements UserRoleService{

    @Autowired
    private UserRoleDao userRoleDao;

    public String findRolesByEmail(String email){
        return userRoleDao.findRolesByEmail(email);
    }

    public boolean findAdminByEmail(String email){
        System.out.println("aaaaaaa"+userRoleDao.findAdminByEmail(email));
        if( userRoleDao.findAdminByEmail(email) == 1)
            return true;
        return false;
    }

    public Long insertRoles(String email, String roles){
        UserRole userRole = new UserRole();
        userRole.setEmail(email);
        userRole.setRoleName(roles);
        return userRoleDao.insertRoles(userRole);
    }

    public Long updateRoles(String email, String roles){
        UserRole userRole = new UserRole();
        userRole.setEmail(email);
        userRole.setRoleName(roles);
        return userRoleDao.updateRoles(userRole);
    }

    public Long deleteRolesByEmail(String email){
        return userRoleDao.deleteRolesByEmail(email);
    }
}
