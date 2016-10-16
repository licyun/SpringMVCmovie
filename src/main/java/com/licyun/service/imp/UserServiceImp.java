package com.licyun.service.imp;

import com.licyun.dao.UserDao;
import com.licyun.model.User;
import com.licyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userdao.findRolesByEmail(email);
    }

    public Set<String> findPermissionsByEmail(String email){
        return userdao.findPermissionsByEmail(email);
    }

    public List<User> findAllUsers(){
        return userdao.findAllUsers();
    }

    public Long insertUser(User user){
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
