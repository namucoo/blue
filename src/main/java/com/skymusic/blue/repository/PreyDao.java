package com.skymusic.blue.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.PreyEntity;

public interface PreyDao extends PagingAndSortingRepository<PreyEntity, Long>, JpaSpecificationExecutor<PreyEntity> {

    
    
}
