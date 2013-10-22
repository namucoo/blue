package com.skymusic.blue.domain.music;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.constant.Constant;
import com.skymusic.blue.constant.ResultCode;
import com.skymusic.blue.domain.util.DomainUtils;
import com.skymusic.blue.entity.Music;
import com.skymusic.blue.result.Result;
import com.skymusic.blue.service.music.MusicService;

@Component
public class MusicDomainService {

	@Autowired
	MusicService musicService;
	
	
	public Result getAllMusic(){
		Result re= new Result(false);
		List<Music> musicList = musicService.getAllMusic(); 
		if(CollectionUtils.isEmpty(musicList)){
			re.put(Constant.errorMsg, ResultCode.all_music_empty);
			return re;
		}
		re.getResultInfo().put(Constant.all_music, DomainUtils.transMusicsToMapList(musicList));
		re.setSuccess(true);
		return re;
	}
	
	
	   public Result getAllCat(){
	        Result re= new Result(false);
	        List<String> catList = musicService.getAllCat(); 
	        if(CollectionUtils.isEmpty(catList)){
	            re.put(Constant.errorMsg, ResultCode.all_music_empty);
	            return re;
	        }
	        re.getResultInfo().put(Constant.all_cat, removeDuplicateCat(catList));
	        re.setSuccess(true);
	        return re;
	    }
	
	   public Result getMusicByCat(String catgory){
	       Result re= new Result(false);
           List<Music> musicList = musicService.getMusicByCat(catgory); 
           if(CollectionUtils.isEmpty(musicList)){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transMusicsToMapList(musicList));
           re.setSuccess(true);
           return re;
	   }
	   
       public Result getVideoMusicByCat(String catgory){
           Result re= new Result(false);
           List<Music> musicList = musicService.getVideoMusicByCat(catgory); 
           if(CollectionUtils.isEmpty(musicList)){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transMusicsToMapList(musicList));
           re.setSuccess(true);
           return re;
       }

       public Result getMusicByTitle(String title){
           Result re= new Result(false);
           Music music = musicService.getMusicByTitle(title); 
           if(music == null){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transOneMusicToMap(music));
           re.setSuccess(true);
           return re;
       }
       
       public Result getVideoMusicByTitle(String title){
           Result re= new Result(false);
           Music music = musicService.getVideoMusicByTitle(title); 
           if(music == null){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transOneMusicToMap(music));
           re.setSuccess(true);
           return re;
       }
       
       public Result getMusicByTone(String tone){
           Result re= new Result(false);
           List<Music> musicList  = musicService.getMusicByTone(tone); 
           if(CollectionUtils.isEmpty(musicList)){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transMusicsToMapList(musicList));
           re.setSuccess(true);
           return re;
       }
       
       public Result getVideoMusicByTone(String tone){
           Result re= new Result(false);
           List<Music> musicList  = musicService.getVideoMusicByTone(tone); 
           if(CollectionUtils.isEmpty(musicList)){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transMusicsToMapList(musicList));
           re.setSuccess(true);
           return re;
       }
       
       public Result getMusicByFirstsong(String firstsong){
           Result re= new Result(false);
           List<Music> musicList = musicService.getMusicByFirstsong(firstsong); 
           if(CollectionUtils.isEmpty(musicList)){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transMusicsToMapList(musicList));
           re.setSuccess(true);
           return re;
       }
       
       private List<String> removeDuplicateCat(List<String> catlist){
           HashSet<String> catSet = new HashSet<String>();
           catSet.addAll(catlist);
           List<String> newCatList = new ArrayList<String>();
           for (String catstr : catSet) {
               newCatList.add(catstr);
        }
           return newCatList;
       }
       
       public Result getVideoMusicByFirstsong(String firstsong){
           Result re= new Result(false);
           List<Music> musicList = musicService.getVideoMusicByFirstsong(firstsong); 
           if(CollectionUtils.isEmpty(musicList)){
               re.put(Constant.errorMsg, ResultCode.all_music_empty);
               return re;
           }
           re.getResultInfo().put(Constant.all_music, DomainUtils.transMusicsToMapList(musicList));
           re.setSuccess(true);
           return re;
       }
}
