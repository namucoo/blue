package com.skymusic.blue.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sky_bible")
public class BibleEntity  extends IdEntity   {

    private String book ;
	

    private String testament ;
	private String chapter ;
	private String stage ;
	private String sentence;
	
    public String getBook() {
        return book;
    }
    
    public void setBook(String book) {
        this.book = book;
    }
    
	public String getTestament() {
		return testament;
	}
	public void setTestament(String testament) {
		this.testament = testament;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
}
