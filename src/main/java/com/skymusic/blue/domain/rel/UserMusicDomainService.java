package com.skymusic.blue.domain.rel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.constant.Constant;
import com.skymusic.blue.constant.ResultCode;
import com.skymusic.blue.entity.Music;
import com.skymusic.blue.entity.UserMusic;
import com.skymusic.blue.result.Result;
import com.skymusic.blue.service.rel.UserMusicRelService;

@Component
public class UserMusicDomainService {

	@Autowired
	UserMusicRelService userMusicRelService;
	
	public Result getAllMusicByUser(Long user_id){
		Result re= new Result(false);
		List<UserMusic> musicList = userMusicRelService.getMusics(user_id) ;
		if(CollectionUtils.isEmpty(musicList)){
			re.put(Constant.errorMsg, ResultCode.all_music_empty);
			return re;
		}
		re.getResultInfo().put(Constant.all_music, transMusicsToMapList(musicList));
		re.setSuccess(true);
		return re;
	}
	
	private List<Map<String,String>> transMusicsToMapList(List<UserMusic> musicList){
		List<Map<String,String>> relist = new ArrayList<Map<String,String>>();
		for (int i = 0; i < musicList.size(); i++) {
			Map<String,String> musicMap = new HashMap<String,String>();
			musicMap.put("title", musicList.get(i).getMusic().getTitle());
			musicMap.put("song_url",musicList.get(i).getMusic().getSong_url());
			musicMap.put("song_word_url",musicList.get(i).getMusic().getSong_word_url());
			musicMap.put("video_url",musicList.get(i).getMusic().getVideo_url());
			musicMap.put("song_type",musicList.get(i).getMusic().getSong_type());
			musicMap.put("extension",musicList.get(i).getMusic().getExtension());
			musicMap.put("memo",musicList.get(i).getMusic().getMemo());
			relist.add(musicMap);
		}
		return relist;
	}
}
