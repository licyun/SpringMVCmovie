package com.licyun.service.imp;

import com.licyun.dao.VideoDao;
import com.licyun.model.Video;
import com.licyun.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据类型分页查询
     * @param type  视频类型
     * @param page  需要查找的页数
     * @param size  每页查询多少数据
     * @return
     */
    public List<Video> findVideosByTypeAndPage(String type, int page, int size){
        //计算开始查找的位置
        if(page < 1)
            page = 1;
        int start = (page - 1) * size;
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("playType", type);
        map.put("start", start);
        map.put("size", size);
        return videoDao.findVideosByTypeAndPage(map);

    }

    /**
     *  查询首页所有视频的分页数据
     * @param page  需要查询的页面
     * @param size  每页查询的数量
     * @return
     */
    public List<Video> findVideosByIndex(int page, int size){
        //计算开始查找的位置
        if(page < 1)
            page = 1;
        int start = (page - 1) * size;
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("start", start);
        map.put("size", size);
        return videoDao.findVideosByIndex(map);
    }

    public List<Video> findAllVideos(){
        return videoDao.findAllVideos();
    }

    public int findVideosCount(){
        return videoDao.findVideosCount();
    }

    public int findVideosCountByType(String type){
        return videoDao.findVideosCountByType(type);
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
