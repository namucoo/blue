package com.skymusic.blue.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.RiteSchedule;


public interface RiteScheduleDao extends PagingAndSortingRepository<RiteSchedule, Long>, JpaSpecificationExecutor<RiteSchedule> {
 
    
    
    public List<RiteSchedule> findAll();
    
    @Query("select p  from RiteSchedule p where p.gmt_create >   ?1   ")
    public List<RiteSchedule> find6day(Date last6day);
    
    @Query("select p  from RiteSchedule p where p.gmt_create >   ?1  and p.ritetype = ?2 ")
    public List<RiteSchedule> findByRiteType(Date last6day,String riteType);
    
    @Query("select p  from RiteSchedule p where p.gmt_create =   ?1  and p.ritetype = ?2 and p.riteschedule = ?3 ")
    public List<RiteSchedule> findByRiteTypeAndRiteSchedule(Date time,String riteType,String riteSchedule);
}
