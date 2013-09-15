package com.skymusic.blue.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.InfoEntity;

public interface InfoDao extends PagingAndSortingRepository<InfoEntity, Long>, JpaSpecificationExecutor<InfoEntity>{

	public InfoEntity findByInfotype(String type);
	
}
