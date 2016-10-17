package com.licyun.controller;

import com.licyun.dao.VideoDao;
import com.licyun.model.Video;
import com.licyun.service.VideoService;
import com.licyun.util.UploadImg;
import com.licyun.util.Validate;
import com.licyun.util.VideoValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/16.
 */
@Controller
public class VideoController {

    //视频图片路径
    private final String IMGURL = "/WEB-INF/img/video";

    @Autowired
    private UploadImg uploadImg;

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoValid videoValid;

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

    @RequestMapping(value = {"/admin/addvideo"}, method = {RequestMethod.GET})
    public String addVideo(Model model) {
        model.addAttribute("video", new Video());
        return "admin/addvideo";
    }
    @RequestMapping(value = {"/admin/addvideo"}, method = {RequestMethod.POST})
    public String addVideo(@Valid Video video, BindingResult result,
                           @RequestParam("file") MultipartFile file,
                           Model model, HttpServletRequest request) {
        videoValid.commonValidate(video, result);
        if( result.hasErrors() ){
            return "admin/addvideo";
        }
        // 上传目录
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("date"+video.getDate());
        String rootPath = request.getServletContext().getRealPath(IMGURL);
        video.setImg(uploadImg.uploadVideoImg(file, video, rootPath));
        videoService.insertVideo(video);
        return "redirect:"+request.getContextPath()+"/admin/index";
    }

    //edit video
    @RequestMapping(value = {"/admin/editvideo-{id}"}, method = {RequestMethod.GET})
    public String editVideo(Model model, @PathVariable int id) {
        model.addAttribute("video", videoService.findById(id));
        return "admin/editvideo";
    }
    @RequestMapping(value = {"/admin/editvideo-{id}"}, method = {RequestMethod.POST})
    public String editVideo(@Valid Video video, @PathVariable int id,
                            @RequestParam("file") MultipartFile file,
                            HttpServletRequest request ) {
        // 上传目录
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("date"+video.getDate());
        video.setImg( videoService.findById(id).getImg() );
        if( file != null){
            String rootPath = request.getServletContext().getRealPath(IMGURL);
            video.setImg(uploadImg.uploadVideoImg(file, video, rootPath));
        }
        videoService.updateVideo(video);
        return "redirect:"+request.getContextPath()+"/admin/videos";
    }

    //delete video
    @RequestMapping(value = {"/admin/deletevideo-{id}"}, method = {RequestMethod.GET})
    public String deleteVideo(@PathVariable int id, HttpServletRequest request) {
        videoService.deleteVideoById(id);
        return "redirect:"+request.getContextPath()+"/admin/videos";
    }
}
