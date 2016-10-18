package com.licyun.service.imp;

import com.licyun.dao.UserDao;
import com.licyun.dao.UserPermissionDao;
import com.licyun.dao.UserRoleDao;
import com.licyun.model.User;
import com.licyun.model.UserPermission;
import com.licyun.model.UserRole;
import com.licyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/14.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userdao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserPermissionDao userPermissionDao;

    public User findByUserId(int id){
        return userdao.findByUserId(id);
    }

    public User findByName(String name){
        return userdao.findByUserName(name);
    }

    public User findByEmail(String email){
        return userdao.findByEmail(email);
    }

    public Set<String> findRolesByEmail(String email){
        //查询到带逗号分隔的角色信息
        String strRoles = userRoleDao.findRolesByEmail(email);
        Set<String> roles = new HashSet<String>();
        //判断是否带逗号分隔，否则会出现空指针异常
        if(strRoles.contains(",")){
            String[] arrRoles = strRoles.split(",");
            for(int i = 0; i < arrRoles.length; i ++){
                roles.add(arrRoles[i]);
            }
        }else {
            roles.add(strRoles);
        }
        return roles;
    }

    public Set<String> findPermissionsByEmail(String email){
        //查询到带逗号分隔的角色信息
        String strPermissions = userPermissionDao.findPermissionsByEmail(email);
        Set<String> permissions = new HashSet<String>();
        //判断是否带逗号分隔，否则会出现空指针异常
        if(strPermissions.contains(",")){
            String[] arrPermissions = strPermissions.split(",");
            for(int i = 0; i < arrPermissions.length; i ++){
                permissions.add(arrPermissions[i]);
            }
        }else {
            permissions.add(strPermissions);
        }
        return permissions;
    }

    public List<User> findAllUsers(){
        return userdao.findAllUsers();
    }

    public Long insertUser(User user){
        //为用户赋予默认角色
        UserRole userRole = new UserRole();
        userRole.setEmail(user.getEmail());
        userRole.setRoleName("user");
        userRoleDao.insertRoles(userRole);
        //为用户赋予默认权限
        UserPermission userPermission = new UserPermission();
        userPermission.setEmail(user.getEmail());
        userPermission.setPermission("user:user");
        userPermissionDao.insertPermissions(userPermission);
        return userdao.insertUser(user);
    }

    public Long updateUser(User user){
        return userdao.updateUser(user);
    }

    public Long updateUserById(User user, int id){
        User sqlUser = userdao.findByUserId(id);
        sqlUser.setEmail(user.getEmail());
        sqlUser.setPassword(user.getPassword());
        sqlUser.setUsername(user.getUsername());
        return userdao.updateUser(sqlUser);
    }

    public Long deleteById(int id){
        return userdao.deleteById(id);
    }

    public boolean isUserEmailExist(String email){
        List<User> users = findAllUsers();
        for(User user : users){
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public boolean isUserEmailExistExceptSelf(String sqlEmail, String localEmail){
        List<User> users = findAllUsers();
        for(User user : users){
            if(!user.getEmail().equals(localEmail)){
                if(user.getEmail().equals(sqlEmail)){
                    return true;
                }
            }
        }
        return false;
    }
}
