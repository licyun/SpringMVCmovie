package com.licyun.util;

import com.licyun.model.User;
import com.licyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/16.
 */
@Component
public class Validate {


    @Autowired
    private UserService userService;

    //公共验证规则
    public void commonValidate(User user, Errors errors) {
        //判断邮箱和密码是否为空
        if(user.getPassword() != "" && user.getEmail() != ""){
            //判断email格式是否则正确
            String pattern = "(.*)@(.).(.*)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(user.getEmail());
            boolean flag = m.matches();
            if(!flag){
                errors.rejectValue("email", "useremail.valid");
            }
            //判断密码格式是否正确
            if(user.getPassword().length() < 6)
                errors.rejectValue("password", "userpasswd.valid");
        }else{
            ValidationUtils.rejectIfEmpty(errors, "password", "userpasswd.required");
            ValidationUtils.rejectIfEmpty(errors, "email", "useremail.required");
        }
    }

    //注册验证
    public void registValidate(User user, Errors errors){
        commonValidate(user, errors);
        //判断name格式是否正确
        if(user.getUsername().length() < 6){
            errors.rejectValue("name", "username.valid");
        }
        //判断邮箱是否已经存在
        if (userService.isUserEmailExist(user.getEmail())) {
            errors.rejectValue("email", "useremail.exist");
        }
    }

    //登录验证
    public void loginValidate(User user, Errors errors){
        commonValidate(user, errors);
        if(!errors.hasErrors()){
            User sqlUser = userService.findByEmail(user.getEmail());
            if(sqlUser != null){
                if(sqlUser.getPassword().equals(user.getPassword())){

                }else{
                    errors.rejectValue("password", "userpasswd.error");
                }
            }else{
                errors.rejectValue("email", "useremail.notexist");
            }
        }
    }

    //登录验证
    public void adminLoginValidate(User user, Errors errors){
        commonValidate(user, errors);
        if(!errors.hasErrors()){
            User sqlUser = userService.findByEmail(user.getEmail());
            if(sqlUser != null){
                if(sqlUser.getPassword().equals(user.getPassword())){
                    boolean isAdmin = false;
                    //判断用户是否具有管理员权限
                    Set<String> roles = userService.findRolesByEmail(user.getEmail());
                    Iterator it = roles.iterator();
                    while (it.hasNext()){
                        String role = (String)it.next();
                        System.out.println(role);
                        if( role.indexOf("admin") != -1 ){
                            isAdmin = true;
                            break;
                        }
                    }
                    if(!isAdmin)
                        errors.rejectValue("email", "useremail.notexist");
                }else{
                    errors.rejectValue("password", "userpasswd.error");
                }
            }else{
                errors.rejectValue("email", "useremail.notexist");
            }
        }
    }

    //修改验证
    public void updateValidate(User user, int id, Errors errors){
        commonValidate(user, errors);
        if(!errors.hasErrors()){
            User sqlUser = userService.findByUserId(id);
            if( userService.isUserEmailExistExceptSelf(sqlUser.getEmail(), user.getEmail()) ){
                errors.rejectValue("email", "useremail.exist");
            }
        }
    }

}
