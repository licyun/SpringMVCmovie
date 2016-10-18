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

    public int findAdminByEmail(String email){
        return userRoleDao.findAdminByEmail(email);
    }

    public boolean findIsAdminByEmail(String email){
        if( userRoleDao.findAdminByEmail(email) == 1)
            return true;
        return false;
    }

    public Long insertRoles(String email, String roles){
        UserRole userRole = new UserRole();
        userRole.setEmail(email);
        userRole.setRoleName(roles);
        userRole.setAdmin(0);
        return userRoleDao.insertRoles(userRole);
    }

    public Long updateRoles(String email, String roles, int admin){
        UserRole userRole = new UserRole();
        userRole.setEmail(email);
        userRole.setRoleName(roles);
        userRole.setAdmin(admin);
        return userRoleDao.updateRoles(userRole);
    }

    public Long deleteRolesByEmail(String email){
        return userRoleDao.deleteRolesByEmail(email);
    }
}
