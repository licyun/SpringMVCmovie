package com.licyun.service.imp;

import com.licyun.dao.UserDao;
import com.licyun.model.User;
import com.licyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/14.
 */
@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userdao;

    public User findByName(String username){
        return userdao.findByUserName(username);
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
