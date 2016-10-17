package com.licyun.controller;

import com.licyun.dao.VideoDao;
import com.licyun.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/16.
 */
@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * video
     */

    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.GET})
    public String list(){
        return "/index";
    }

    @RequestMapping(value = {"/list/{type}"}, method = {RequestMethod.GET})
    public String list(@PathVariable String type, Model model){
        model.addAttribute("type", type);
        return "movie/list";
    }

    @RequestMapping(value = {"/description/{type}-{id}"}, method = {RequestMethod.GET})
    public String description(@PathVariable  int id, @PathVariable String type,
                              Model model){
        model.addAttribute("video", videoService.findById(id));
        return "movie/description";
    }

    @RequestMapping(value = {"/play/{type}-{id}"}, method = {RequestMethod.GET})
    public String play(@PathVariable String type, @PathVariable  int id,
                       Model model){
        model.addAttribute("video", videoService.findById(id));
        return "movie/play";
    }

    @RequestMapping(value = {"/ckplay/{type}-{vid}"}, method = {RequestMethod.GET})
    public String ckPlay(@PathVariable String type, @PathVariable String vid,
                         Model model){
        model.addAttribute("type", type);
        model.addAttribute("vid", vid);
        return "movie/ckplay";
    }
}
