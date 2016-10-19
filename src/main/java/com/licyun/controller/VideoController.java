package com.licyun.controller;

import com.licyun.model.Video;
import com.licyun.service.VideoService;
import com.licyun.util.UploadImg;
import com.licyun.util.VideoValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

    private static Logger logger = LoggerFactory.getLogger(VideoController.class);

    /**
     * video
     */

    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.GET})
    public String list(Model model){
        //总页面数
        int pageCount = (int)Math.ceil(videoService.findVideosCount() / 4.0f);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("videos", videoService.findAllVideos());
        logger.debug("test");
        return "/index";
    }

    //分页json数据
    @ResponseBody
    @RequestMapping(value = {"/jsonPage-{type}-{page}"}, method = {RequestMethod.GET})
    public List<Video> jsonPage(@PathVariable String type, @PathVariable int page ){
        //每页大小
        int size = 4;
        List<Video> pages = videoService.findVideosByTypeAndPage(type, page, size);
        return pages;
    }

    @RequestMapping(value = {"/list/{type}"}, method = {RequestMethod.GET})
    public String list(@PathVariable String type, Model model){
        //总页面数
        int pageCount = (int)Math.ceil(videoService.findVideosCountByType(type) / 4.0f);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("type", type);
        model.addAttribute("videos", videoService.findVideosByPlayType(type));
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
        String rootPath = request.getServletContext().getRealPath(IMGURL);
        video.setImg(uploadImg.uploadVideoImg(file, video, rootPath));
        videoService.insertVideo(video);
        return "redirect:"+request.getContextPath()+"/admin/videos";
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
        if( file == null || file.isEmpty()){
            video.setImg( videoService.findById(id).getImg() );
        }else {
            String rootPath = request.getServletContext().getRealPath(IMGURL);
            video.setImg(uploadImg.uploadVideoImg(file, video, rootPath));
        }
        videoService.updateVideo(video);
        return "redirect:"+request.getContextPath()+"/admin/videos";
    }

    //delete video
    @RequestMapping(value = {"/admin/deletevideo-{id}"}, method = {RequestMethod.GET})
    public String deleteVideo(@PathVariable int id, HttpServletRequest request) {
        String rootPath = request.getServletContext().getRealPath(IMGURL);
        videoService.deleteVideoById(id, rootPath);
        return "redirect:"+request.getContextPath()+"/admin/videos";
    }
}
