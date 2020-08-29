package com.uprep.userms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uprep.userms.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(nativeQuery = true, value = "select * from users where login_id=?1 AND password=2")
	User findByLoginIdAndPassword(String loginId, String password);
}
