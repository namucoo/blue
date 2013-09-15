package com.skymusic.blue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.UserMusic;


public interface UserMusicDao extends PagingAndSortingRepository<UserMusic, Long>, JpaSpecificationExecutor<UserMusic>{

	@Modifying
	@Query("delete from UserMusic userMusic where userMusic.user.id=?1")
	void deleteByUserId(Long id);
	
	public List<UserMusic> findByUserId(Long id);
}
