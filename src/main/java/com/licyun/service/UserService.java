package com.licyun.service;

import com.licyun.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/14.
 */
public interface UserService {

    User findByUserId(int id);

    User findByName(String name);

    User findByEmail(String email);

    Set<String> findRolesByEmail(String email);

    Set<String> findPermissionsByEmail(String email);

    List<User> findAllUsers();

    Long insertUser(User user);

    Long updateUser(User user);

    Long updateUserById(User user, int id);

    Long deleteById(int id);

    boolean isUserEmailExist(String email);

    boolean isUserEmailExistExceptSelf(String sqlEmail, String localEmail);
}
