package com.skymusic.blue.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.MobileSession;

public interface MobileSessionDao  extends PagingAndSortingRepository<MobileSession, Long>, JpaSpecificationExecutor<MobileSession> {
	public MobileSession findByUserId(Long id);
}
