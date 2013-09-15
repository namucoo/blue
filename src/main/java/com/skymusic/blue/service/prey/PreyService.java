package com.skymusic.blue.service.prey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.skymusic.blue.entity.PreyEntity;
import com.skymusic.blue.repository.InfoDao;
import com.skymusic.blue.repository.PreyDao;
import com.skymusic.blue.repository.UserDao;
import com.skymusic.blue.service.utils.SkyRequestUtils;

@Component
public class PreyService {

    private PreyDao preyDao;

    private UserDao userDao;

    public void sendPrey(String userName, String memo) {
        PreyEntity entity = new PreyEntity();
        entity.setUser(userDao.findByLogin_name(userName));
        entity.setMemo(memo);
        preyDao.save(entity);
    }

    public List<PreyEntity> listPrey(int pageNumber, String sortType) {
        PageRequest pageRequest = SkyRequestUtils.buildPageRequest(pageNumber, 20, sortType);
        return preyDao.findAll(pageRequest).getContent();
    }

    @Autowired
    public void setPreyDao(PreyDao preyDao) {
        this.preyDao = preyDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
