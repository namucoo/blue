package com.skymusic.blue.service.share;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.entity.ShareEntity;
import com.skymusic.blue.repository.MobileUserDao;
import com.skymusic.blue.repository.ShareDao;

@Component
public class ShareService {

    private ShareDao shareDao;
    private MobileUserDao  mobileUserDao;

    public void sendShare(String userName, String memo) {
        ShareEntity entity = new ShareEntity();
        entity.setMobileUser(mobileUserDao.findByLoginname(userName));
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
    public void setMobileUserDao(MobileUserDao mobileUserDao) {
        this.mobileUserDao = mobileUserDao;
    }
}
