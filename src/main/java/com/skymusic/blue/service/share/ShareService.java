package com.skymusic.blue.service.share;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.skymusic.blue.entity.PreyEntity;
import com.skymusic.blue.entity.ShareEntity;
import com.skymusic.blue.repository.ShareDao;
import com.skymusic.blue.repository.UserDao;
import com.skymusic.blue.service.utils.SkyRequestUtils;

@Component
public class ShareService {

    private ShareDao shareDao;
    private UserDao  userDao;

    public void sendShare(String userName, String memo) {
        ShareEntity entity = new ShareEntity();
        entity.setUser(userDao.findByLogin_name(userName));
        entity.setMemo(memo);
        entity.setSelected("n");
        shareDao.save(entity);
    }

    public List<ShareEntity> listShare() {
        List<ShareEntity> shareList = new ArrayList<ShareEntity>();
        List<ShareEntity> selectedList = shareDao.findBySelected("y");
        List<ShareEntity> noSelectedList = shareDao.findBySelected("n");
        if (selectedList.size() > 3) {
            shareList.addAll(selectedList.subList(0, 3));
        } else {
            shareList.addAll(selectedList);
        }

        if (noSelectedList.size() > 3) {
            shareList.addAll(noSelectedList.subList(0, 3));
        } else {
            shareList.addAll(noSelectedList);
        }

        return shareList;
    }

    @Autowired
    public void setShareDao(ShareDao shareDao) {
        this.shareDao = shareDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
