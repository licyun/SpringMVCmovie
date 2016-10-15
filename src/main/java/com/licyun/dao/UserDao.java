package com.licyun.dao;

import com.licyun.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/14.
 */
public interface UserDao {

    User findByUserName(String userName);

    Set<String> findRolesByUserName(String userName);

    Set<String> findPermissionsByUserName(String userName);

    List<User> findAllUsers();

    Long insertUser(User user);

    Long updateUser(User user);

    Long deleteById(int id);

}
