package com.skymusic.blue.service.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.skymusic.blue.entity.Resource;
import com.skymusic.blue.repository.ResourceDao;

//Spring Bean的标识.
@Component
//默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class ResourceService {

	private ResourceDao resourceDao;

	public Resource getResource(Long id) {
		return resourceDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void saveResource(Resource entity) {
		resourceDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteResource(Long id) {
		resourceDao.delete(id);
	}

	public List<Resource> getAllResource() {
		return (List<Resource>) resourceDao.findAll();
	}
	
	
	
	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	
}
