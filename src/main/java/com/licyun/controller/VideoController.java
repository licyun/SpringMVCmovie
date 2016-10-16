package com.licyun.controller;

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

    /**
     * movie
     */
    @RequestMapping(value = {"/list/{type}"}, method = {RequestMethod.GET})
    public String list(@PathVariable String type, Model model){
        model.addAttribute("type", type);
        return "movie/list";
    }

    @RequestMapping(value = {"/description/{type}-{mid}"}, method = {RequestMethod.GET})
    public String description(@PathVariable  int mid, @PathVariable String type,
                              Model model){
        model.addAttribute("type", type);
        return "movie/description";
    }

    @RequestMapping(value = {"/play/{type}-{mid}"}, method = {RequestMethod.GET})
    public String play(@PathVariable String type, @PathVariable  int mid,
                       Model model){
        model.addAttribute("type", type);
        return "movie/play";
    }

    @RequestMapping(value = {"/ckplay/{type}-{vid}"}, method = {RequestMethod.GET})
    public String ckPlay(@PathVariable String type, @PathVariable String vid, Model model){
        model.addAttribute("vid", vid);
        return "movie/ckplay";
    }
}
