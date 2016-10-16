package com.licyun.controller;

import com.licyun.model.User;
import com.licyun.service.UserService;
import com.licyun.util.UploadImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/14.
 */
@Controller
public class UserController {

    //图片路径
    private final String IMGURL = "/WEB-INF/img";

    @Autowired
    private UploadImg uploadImg;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/user/login"}, method = {RequestMethod.GET})
    public String login(Model model){
        model.addAttribute("user", new User());
        return "user/login";
    }
    @RequestMapping(value = {"/user/login"}, method = {RequestMethod.POST})
    public String login(@Valid User user, Model model){
        model.addAttribute("user", new User());
        return "user/login";
    }

    @RequestMapping(value = {"/user", "/user/index"}, method = {RequestMethod.GET})
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = {"/user/edituser-{uid}"}, method = {RequestMethod.GET})
    public String editUser(@PathVariable int uid, Model model){
        model.addAttribute("user", new User());
        return "user/edituser";
    }

    @RequestMapping(value = {"/user/editimg-{uid}"}, method = {RequestMethod.GET})
    public String editImg(@PathVariable int uid, Model model){
        model.addAttribute("user", userService.findByUserId(uid));
        return "user/editimg";
    }

    /**
     * 修改图片 post
     * @param request
     * @param session
     * @param file    图片文件
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/edit-img", method = RequestMethod.POST)
    public String uploadFileHandler(HttpServletRequest request, HttpSession session,
                                    @RequestParam("file") MultipartFile file, Model model) {
        User user = (User) session.getAttribute("user");
        // 上传目录
        String rootPath = request.getServletContext().getRealPath(IMGURL);
        System.out.println(rootPath);
        uploadImg.uploadimg(file, user, rootPath);
        model.addAttribute("user", user);
        return "user/index";
    }


}
