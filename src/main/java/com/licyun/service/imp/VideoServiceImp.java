package com.licyun.service.imp;

import com.licyun.dao.VideoDao;
import com.licyun.model.Video;
import com.licyun.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/17.
 */
@Service
public class VideoServiceImp implements VideoService {

    //视频图片路径
    private final String IMGURL = "/WEB-INF/img/video";

    @Autowired
    private VideoDao videoDao;

    public Video findById(int id){
        return videoDao.findById(id);
    }

    public Video findByName(String name){
        return videoDao.findByName(name);
    }

    public List<Video> findVideosByPlayType(String type){
        return videoDao.findVideosByPlayType(type);
    }

    public List<Video> findAllVideos(){
        return videoDao.findAllVideos();
    }

    public Long insertVideo(Video video){

        return videoDao.insertVideo(video);
    }

    public Long updateVideo(Video video){
        return videoDao.updateVideo(video);
    }

    public Long deleteVideoById(int id, String rootPath){
        String img = videoDao.findById(id).getImg();
        if(img == null || img.isEmpty() ){

        }else{
            String imgurl = rootPath +  File.separator + img;
            File imgFile = new File(imgurl);
            imgFile.delete();
        }
        return videoDao.deleteVideoById(id);
    }
}
