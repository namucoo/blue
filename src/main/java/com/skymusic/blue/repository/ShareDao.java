package com.skymusic.blue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.ShareEntity;

public interface ShareDao extends PagingAndSortingRepository<ShareEntity, Long>, JpaSpecificationExecutor<ShareEntity> {
    
    public List<ShareEntity> findBySelected(String selected);
    
//    public List<ShareEntity> findBySelectedOrderById(String selected);
}
