package com.skymusic.blue.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.Resource;

public interface ResourceDao extends PagingAndSortingRepository<Resource, Long>, JpaSpecificationExecutor<Resource> {

	Page<Resource> findByUserId(Long id, Pageable pageRequest);

	@Modifying
	@Query("delete from Resource resource where resource.user.id=?1")
	void deleteByUserId(Long id);
}