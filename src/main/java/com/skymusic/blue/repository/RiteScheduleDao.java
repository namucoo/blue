package com.skymusic.blue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.RiteSchedule;


public interface RiteScheduleDao extends PagingAndSortingRepository<RiteSchedule, Long>, JpaSpecificationExecutor<RiteSchedule> {
 
    public List<RiteSchedule> findAll();
}
