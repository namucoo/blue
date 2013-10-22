package com.skymusic.blue.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.Music;

public interface MusicDao extends PagingAndSortingRepository<Music, Long>, JpaSpecificationExecutor<Music>{
	

    @Query("select category  from Music")
	public List<String> findCategory();
    
    public List<Music> findByCategory(String category);
    
    @Query("select p  from Music p where p.category=?1  and p.video_url is not null and p.video_url != '' ")
    public List<Music> findByCategoryAndVideo_urlNotNull(String category);
    
    public Music findByTitle(String title);
    
    @Query("select p  from Music p where p.title=?1 and p.video_url is not null  and p.video_url != '' ")
    public Music findByTitleAndVideo_urlNotNull(String title);
    
    public List<Music> findByToneLike(String tone);
    
    @Query("select p  from Music p where p.tone like ?1 and p.video_url is not null  and p.video_url != '' ")
    public List<Music> findByVideo_urlNotNullAndToneLike(String tone);
    
    public List<Music> findByFirstsongLike(String firstsong);
    
    @Query("select p  from Music p where p.firstsong like ?1 and p.video_url is not null  and p.video_url != '' ")
    public List<Music> findByVideo_urlNotNullAndFirstsongLike(String firstsong);
    
}
