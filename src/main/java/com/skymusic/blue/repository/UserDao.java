package com.skymusic.blue.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.skymusic.blue.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
