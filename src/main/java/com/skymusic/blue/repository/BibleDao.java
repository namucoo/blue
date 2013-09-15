package com.skymusic.blue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.BibleEntity;

public interface BibleDao extends PagingAndSortingRepository<BibleEntity, Long>, JpaSpecificationExecutor<BibleEntity>{

    
    public List<BibleEntity> findByTestament(String testament);
    
    public List<BibleEntity> findByTestamentAndChapter(String testament,String chapter);
    
    public List<BibleEntity> findByTestamentOrChapterOrStage(String testament,String chapter,String stage);
    
    public List<BibleEntity> findByTestamentAndChapterAndStage(String testament,String chapter,String stage);
    
    public List<BibleEntity> findBySentenceLike(String key);
}
