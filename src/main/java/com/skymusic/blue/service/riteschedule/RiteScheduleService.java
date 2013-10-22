package com.skymusic.blue.service.riteschedule;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.entity.RiteSchedule;
import com.skymusic.blue.repository.RiteScheduleDao;

@Component
public class RiteScheduleService {

    private RiteScheduleDao riteScheduleDao;

    public List<RiteSchedule> getRiteScheduleList() {
        return riteScheduleDao.findAll();
    }

    public List<RiteSchedule> getRiteScheduleListByParam(String dateStr, String riteType, String riteSchedule) {
        Date date;
        try {
            date = Date.valueOf(dateStr);
        } catch (Exception e) {
            return null;
        }

        return riteScheduleDao.findByRiteTypeAndRiteSchedule(date, riteType, riteSchedule);

    }

    public List<RiteSchedule> getRiteScheduleListByParam(String riteType, String riteSchedule) {
        Calendar cd = Calendar.getInstance();
        cd.add(Calendar.DATE, -6);// 减6天
        if (StringUtils.isBlank(riteSchedule)) {
//            return riteScheduleDao.findByRiteType(cd.getTime(), riteType);
            return null;
        } else {
            return null;
//            return riteScheduleDao.findByRiteTypeAndRiteSchedule(cd.getTime(), riteType, riteSchedule);
        }

    }

    @Autowired
    public void setRiteScheduleDao(RiteScheduleDao riteScheduleDao) {
        this.riteScheduleDao = riteScheduleDao;
    }

}
