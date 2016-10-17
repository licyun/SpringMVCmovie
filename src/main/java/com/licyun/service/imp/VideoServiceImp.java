package com.licyun.service.imp;

import com.licyun.dao.VideoDao;
import com.licyun.model.Video;
import com.licyun.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/17.
 */
@Service
public class VideoServiceImp implements VideoService {

    @Autowired
    private VideoDao videoDao;

    public Video findById(int id){
        return videoDao.findById(id);
    }

    public Video findByName(String name){
        return videoDao.findByName(name);
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

    public Long deleteVideoById(int id){
        return videoDao.deleteVideoById(id);
    }
}
