package com.skymusic.blue.domain.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.skymusic.blue.entity.BibleEntity;
import com.skymusic.blue.entity.Music;
import com.skymusic.blue.entity.PreyEntity;
import com.skymusic.blue.entity.RiteSchedule;
import com.skymusic.blue.entity.ShareEntity;

public class DomainUtils {

    public static List<Map<String, String>> transMusicsToMapList(List<Music> musicList) {
        List<Map<String, String>> relist = new ArrayList<Map<String, String>>();
        for (int i = 0; i < musicList.size(); i++) {
            Map<String, String> musicMap = new HashMap<String, String>();
            musicMap.put("title", musicList.get(i).getTitle());
            musicMap.put("category", musicList.get(i).getCategory());
            musicMap.put("secondcat", musicList.get(i).getSecondcat());
            musicMap.put("song_url", musicList.get(i).getSong_url());
            musicMap.put("song_word_url", musicList.get(i).getSong_word_url());
            musicMap.put("video_url", musicList.get(i).getVideo_url());
            musicMap.put("song_type", musicList.get(i).getSong_type());
            musicMap.put("extension", musicList.get(i).getExtension());
            musicMap.put("tone", musicList.get(i).getTone());
            musicMap.put("firstsong", musicList.get(i).getFirstsong());
            musicMap.put("memo", musicList.get(i).getMemo());
            relist.add(musicMap);
        }
        return relist;
    }
    
    public static List<String> removeDuplicate(List<String> strlist){
        HashSet<String> strSet = new HashSet<String>();
        strSet.addAll(strlist);
        List<String> newStrList = new ArrayList<String>();
        for (String catstr : strSet) {
            newStrList.add(catstr);
     }
        return newStrList;
    }

    public static Map<String, String> transOneMusicToMap(Music music) {

        Map<String, String> musicMap = new HashMap<String, String>();
        musicMap.put("title", music.getTitle());
        musicMap.put("category", music.getCategory());
        musicMap.put("secondcat", music.getSecondcat());
        musicMap.put("song_url", music.getSong_url());
        musicMap.put("song_word_url", music.getSong_word_url());
        musicMap.put("video_url", music.getVideo_url());
        musicMap.put("song_type", music.getSong_type());
        musicMap.put("extension", music.getExtension());
        musicMap.put("tone", music.getTone());
        musicMap.put("firstsong", music.getFirstsong());
        musicMap.put("memo", music.getMemo());
        return musicMap;
    }

    public static List<Map<String, String>> transBibleToMapList(List<BibleEntity> bibleList) {
        List<Map<String, String>> relist = new ArrayList<Map<String, String>>();
        for (int i = 0; i < bibleList.size(); i++) {
            Map<String, String> bibleMap = new HashMap<String, String>();
            bibleMap.put("testament", bibleList.get(i).getTestament());
            bibleMap.put("chapter", bibleList.get(i).getChapter());
            bibleMap.put("stage", bibleList.get(i).getStage());
            bibleMap.put("sentence", bibleList.get(i).getSentence());
            relist.add(bibleMap);
        }
        return relist;
    }

    public static List<Map<String, String>> transRiteToMapList(List<RiteSchedule> riteList) {
        List<Map<String, String>> relist = new ArrayList<Map<String, String>>();
        for (int i = 0; i < riteList.size(); i++) {
            Map<String, String> reMap = new HashMap<String, String>();
            reMap.put("ritetype", riteList.get(i).getRitetype());
            reMap.put("riteschedule", riteList.get(i).getRiteschedule());
            reMap.put("title", riteList.get(i).getTitle());
            reMap.put("memo", riteList.get(i).getMemo());
            reMap.put("time", riteList.get(i).getGmt_create().toString());
            relist.add(reMap);
        }
        return relist;
    }

    public static List<Map<String, String>> transPreyToMapList(List<PreyEntity> preyList) {
        List<Map<String, String>> relist = new ArrayList<Map<String, String>>();
        for (int i = 0; i < preyList.size(); i++) {
            Map<String, String> reMap = new HashMap<String, String>();
            reMap.put("loginname", preyList.get(i).getMobileUser().getLoginname());
            reMap.put("prey", preyList.get(i).getMemo());
            relist.add(reMap);
        }
        return relist;
    }

    public static List<Map<String, String>> transShareToMapList(List<ShareEntity> shareList) {
        List<Map<String, String>> relist = new ArrayList<Map<String, String>>();
        for (int i = 0; i < shareList.size(); i++) {
            Map<String, String> reMap = new HashMap<String, String>();
            reMap.put("loginname", shareList.get(i).getMobileUser().getLoginname());
            reMap.put("selected", shareList.get(i).getSelected());
            reMap.put("memo", shareList.get(i).getMemo());
            relist.add(reMap);
        }
        return relist;
    }
}
