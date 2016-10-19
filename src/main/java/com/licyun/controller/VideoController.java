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

    //log4j调试bug用
    private static Logger logger = LoggerFactory.getLogger(VideoController.class);

    /**
     * 视频首页
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.GET})
    public String list(Model model){
        //总页面数
        int pageCount = (int)Math.ceil(videoService.findVideosCount() / 4.0f);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("videos", videoService.findVideosByIndex(1, 4));
        return "/index";
    }

    /**
     * 分页json数据
     * @param type  视频类型，index为首页
     * @param page  第几页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/jsonPage-{type}-{page}"}, method = {RequestMethod.GET})
    public List<Video> jsonPage(@PathVariable String type, @PathVariable int page ){
        //每页大小
        int size = 4;
        //当type为首页时，不需要按type查找
        logger.debug(type);
        if( type.equals("index") ){
            return videoService.findVideosByIndex(page, size);
        }
        return videoService.findVideosByTypeAndPage(type, page, size);
    }

    /**
     * 视频列表页
     * @param type  视频类型
     * @param model
     * @return
     */
    @RequestMapping(value = {"/list/{type}"}, method = {RequestMethod.GET})
    public String list(@PathVariable String type, Model model){
        //总页面数
        int pageCount = (int)Math.ceil(videoService.findVideosCountByType(type) / 4.0f);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("type", type);
        model.addAttribute("videos", videoService.findVideosByPlayType(type));
        return "movie/list";
    }

    /**
     * 视频描述页面
     * @param id
     * @param type
     * @param model
     * @return
     */
    @RequestMapping(value = {"/description/{type}-{id}"}, method = {RequestMethod.GET})
    public String description(@PathVariable  int id, @PathVariable String type,
                              Model model){
        model.addAttribute("video", videoService.findById(id));
        return "movie/description";
    }

    /**
     * 视频播放页面
     * @param type  视频类型
     * @param id    视频id
     * @param model
     * @return
     */
    @RequestMapping(value = {"/play/{type}-{id}"}, method = {RequestMethod.GET})
    public String play(@PathVariable String type, @PathVariable  int id,
                       Model model){
        model.addAttribute("video", videoService.findById(id));
        return "movie/play";
    }

    /**
     * 调用ckPlayer播放器解析播放视频
     * @param type  视频类型
     * @param vid   视频vid,来自优酷网的视频id
     * @param model
     * @return
     */
    @RequestMapping(value = {"/ckplay/{type}-{vid}"}, method = {RequestMethod.GET})
    public String ckPlay(@PathVariable String type, @PathVariable String vid,
                         Model model){
        model.addAttribute("type", type);
        model.addAttribute("vid", vid);
        return "movie/ckplay";
    }

    /**
     * 添加视频
     * @param model
     * @return
     */
    @RequestMapping(value = {"/admin/addvideo"}, method = {RequestMethod.GET})
    public String addVideo(Model model) {
        model.addAttribute("video", new Video());
        return "admin/addvideo";
    }
    @RequestMapping(value = {"/admin/addvideo"}, method = {RequestMethod.POST})
    public String addVideo(@Valid Video video, BindingResult result,
                           @RequestParam("file") MultipartFile file,
                           Model model, HttpServletRequest request) {
        //验证输入规则是否正确
        videoValid.commonValidate(video, result);
        if( result.hasErrors() ){
            return "admin/addvideo";
        }
        // 视频图片上传路径
        String rootPath = request.getServletContext().getRealPath(IMGURL);
        //图片上传完成后将图片路径写入数据表中
        video.setImg(uploadImg.uploadVideoImg(file, video, rootPath));
        videoService.insertVideo(video);
        return "redirect:"+request.getContextPath()+"/admin/videos";
    }

    /**
     * 编辑视频
     * @param model
     * @param id    视频id
     * @return
     */
    @RequestMapping(value = {"/admin/editvideo-{id}"}, method = {RequestMethod.GET})
    public String editVideo(Model model, @PathVariable int id) {
        model.addAttribute("video", videoService.findById(id));
        return "admin/editvideo";
    }
    @RequestMapping(value = {"/admin/editvideo-{id}"}, method = {RequestMethod.POST})
    public String editVideo(@Valid Video video, @PathVariable int id,
                            @RequestParam("file") MultipartFile file,
                            HttpServletRequest request ) {
        //判断当图片为空时不修改图片，避免图片被初始化
        if( file == null || file.isEmpty()){
            video.setImg( videoService.findById(id).getImg() );
        }else {
            String rootPath = request.getServletContext().getRealPath(IMGURL);
            video.setImg(uploadImg.uploadVideoImg(file, video, rootPath));
        }
        videoService.updateVideo(video);
        return "redirect:"+request.getContextPath()+"/admin/videos";
    }

    /**
     * 删除视频
     * @param id        视频id
     * @param request
     * @return
     */
    @RequestMapping(value = {"/admin/deletevideo-{id}"}, method = {RequestMethod.GET})
    public String deleteVideo(@PathVariable int id, HttpServletRequest request) {
        //删除视频前先删除图片
        String rootPath = request.getServletContext().getRealPath(IMGURL);
        videoService.deleteVideoById(id, rootPath);
        return "redirect:"+request.getContextPath()+"/admin/videos";
    }
}
