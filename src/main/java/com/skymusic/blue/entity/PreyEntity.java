package com.skymusic.blue.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sky_prey")
public class PreyEntity extends IdEntity {

    private Date   gmt_create;
    private User   user;
    private String memo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmtCreate) {
        this.gmt_create = gmtCreate;
    }

    @ManyToOne
    @JoinColumn(name = "login_name")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
