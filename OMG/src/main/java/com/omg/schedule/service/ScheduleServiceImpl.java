package com.omg.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omg.cmn.Criteria;
import com.omg.schedule.dao.ScheduleDao;
import com.omg.schedule.domain.ScheduleVO;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
    final Logger LOG = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    
    @Autowired
    private ScheduleDao scheduleDao;

    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public ScheduleServiceImpl() {}
    
    /**
     * ?Ό? μΆκ?
     */
    @Override
    public int doInsert(ScheduleVO schedule) {
	return scheduleDao.doInsert(schedule);
    }

    /**
     * ?Ό? ?­? 
     */
    @Override
    public int doDelete(ScheduleVO schedule) {
	return scheduleDao.doDelete(schedule);
    }

    /**
     * ?Ό? ?? 
     */
    @Override
    public int doUpdate(ScheduleVO schedule) {
	return scheduleDao.doUpdate(schedule);
    }

    /**
     * ?Ό? ? ?
     */
    @Override
    public ScheduleVO doSelectOne(ScheduleVO schedule) {
	return scheduleDao.doSelectOne(schedule);
    }

    /**
     * ?Ό?  λ¦¬μ€?Έ?
     */
    @Override
    public List<ScheduleVO> doSelectList(Criteria cri) {
	return scheduleDao.doSelectList(cri);
    }

    @Override
    public int getTotalCount(Criteria cri) {
	return scheduleDao.getTotalCount(cri);
    }

}
