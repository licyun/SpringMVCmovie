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

    public Set<String> findRolesByUserName(String userName){
        return userdao.findRolesByUserName(userName);
    }

    public Set<String> findPermissionsByUserName(String userName){
        return userdao.findPermissionsByUserName(userName);
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

    public Long deleteById(int id){
        return userdao.deleteById(id);
    }
}
