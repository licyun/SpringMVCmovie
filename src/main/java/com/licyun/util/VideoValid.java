package com.licyun.util;

import com.licyun.model.User;
import com.licyun.model.Video;
import com.licyun.service.UserService;
import com.licyun.service.VideoService;
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
 * 2016/10/17.
 */
@Component
public class VideoValid {

    @Autowired
    private VideoService videoService;

    //公共验证规则
    public void commonValidate(Video video, Errors errors) {
        //判断邮箱和密码是否为空
        if(video.getName() != "" && video.getType() != ""){
            //判断评分格式
            if( video.getScore() != null ){

            }else {
                errors.rejectValue("score", "video.score.required");
            }
        }else{
            ValidationUtils.rejectIfEmpty(errors, "name", "video.name.required");
            ValidationUtils.rejectIfEmpty(errors, "type", "video.type.required");
        }
    }

    //修改验证
    public void updateValidate(User user, int id, Errors errors){

    }

}
