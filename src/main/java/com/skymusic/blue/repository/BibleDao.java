package com.skymusic.blue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.skymusic.blue.entity.BibleEntity;

public interface BibleDao extends PagingAndSortingRepository<BibleEntity, Long>, JpaSpecificationExecutor<BibleEntity>{

    public List<BibleEntity> findByBook(String book);
    
    public List<BibleEntity> findByBookAndTestament(String book,String testament);
    
    public List<BibleEntity> findByBookAndChapter(String book,String testament);
 
    public List<BibleEntity> findByBookAndTestamentAndChapter(String book,String testament,String chapter);
    
    public List<BibleEntity> findByTestamentOrChapterOrStage(String testament,String chapter,String stage);
    
    public List<BibleEntity> findByTestamentAndChapterAndStage(String testament,String chapter,String stage);
    
    public List<BibleEntity> findBySentenceLike(String key);
    
    @Query("select distinct(testament)  from BibleEntity p where p.book = ?1 ")
    public List<String> findTestamentByBook(String book);
    
    @Query("select distinct(chapter)  from BibleEntity p where p.book = ?1 and p.testament = ?2")
    public List<String> findChapterByBookAndTestament(String book,String testament);
}
