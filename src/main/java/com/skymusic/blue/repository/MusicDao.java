package com.skymusic.blue.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.Music;

public interface MusicDao extends PagingAndSortingRepository<Music, Long>, JpaSpecificationExecutor<Music>{
	
	
}
