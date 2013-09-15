package com.skymusic.blue.domain.music;

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
	
	

}
