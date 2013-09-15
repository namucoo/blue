package com.skymusic.blue.service.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.skymusic.blue.entity.Music;
import com.skymusic.blue.repository.MusicDao;

@Component
public class MusicService {
	
	private MusicDao musicDao;
	
	public Music getMusic(Long id) {
		return musicDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void saveMusic(Music entity) {
		musicDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteMusic(Long id) {
		musicDao.delete(id);
	}

	public List<Music> getAllMusic() {
		return (List<Music>) musicDao.findAll();
	}

//	public Page<Music> getUserMusic(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
//			String sortType) {
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Music> spec = buildSpecification(userId, searchParams);
//
//		return musicDao.findAll(spec, pageRequest);
//	}

//	/**
//	 * 创建分页请求.
//	 */
//	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
//		Sort sort = null;
//		if ("auto".equals(sortType)) {
//			sort = new Sort(Direction.DESC, "id");
//		} else if ("title".equals(sortType)) {
//			sort = new Sort(Direction.ASC, "title");
//		}
//
//		return new PageRequest(pageNumber - 1, pagzSize, sort);
//	}
//
//	/**
//	 * 创建动态查询条件组合.
//	 */
//	private Specification<Music> buildSpecification(Long userId, Map<String, Object> searchParams) {
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//		Specification<Music> spec = DynamicSpecifications.bySearchFilter(filters.values(), Music.class);
//		return spec;
//	}

	@Autowired
	public void setmusicDao(MusicDao musicDao) {
		this.musicDao = musicDao;
	}
}
