package com.licyun.controller;

import com.licyun.model.User;
import com.licyun.service.UserService;
import com.licyun.util.Validate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/16.
 */
@Controller
public class AdminController {

    @Autowired
    private Validate validate;

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param model
     * @return
     */
    @RequestMapping(value = {"/admin/login"}, method = {RequestMethod.GET})
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "admin/login";
    }
    @RequestMapping(value = {"/admin/login"}, method = {RequestMethod.POST})
    public String login(@Valid User user, BindingResult result,
                        Model model){
        //管理员登录验证
        validate.adminLoginValidate(user, result);
        if(result.hasErrors()){
            return "admin/login";
        }
        model.addAttribute("users", userService.findAllUsers());
        return "admin/index";

    }

    @RequestMapping(value = {"/admin/index", "/admin"}, method = {RequestMethod.GET})
    public String admin(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "admin/index";
    }

    @RequestMapping(value = {"/admin/edituser-{uid}"}, method = {RequestMethod.GET})
    public String editUser(@PathVariable int uid, Model model) {
        model.addAttribute("user", new User());
        return "admin/edituser";
    }

    @RequestMapping(value = {"/admin/editimg-{uid}"}, method = {RequestMethod.GET})
    public String editImg(@PathVariable int uid) {

        return "admin/editimg";
    }

    @RequestMapping(value = {"/admin/403"}, method = {RequestMethod.GET})
    public String noPermission() {
        return "admin/403";
    }

}
