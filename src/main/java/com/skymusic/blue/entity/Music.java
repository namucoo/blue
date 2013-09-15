package com.skymusic.blue.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "sky_music")
public class Music  extends IdEntity {
	

	private String creator_id;
	private String title;
	private String song_url;
	private String song_word_url;
	private String video_url;
	private String song_type;
	private String extension;
	private String memo;

	public String getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}
	
	@NotBlank
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSong_url() {
		return song_url;
	}
	public void setSong_url(String song_url) {
		this.song_url = song_url;
	}
	public String getSong_word_url() {
		return song_word_url;
	}
	public void setSong_word_url(String song_word_url) {
		this.song_word_url = song_word_url;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getSong_type() {
		return song_type;
	}
	public void setSong_type(String song_type) {
		this.song_type = song_type;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	
}
