package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csmtech.model.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

	@Query("FROM MyUser where isActive=true")
	List<MyUser> findAllActiveUser();

	@Transactional
	@Modifying
	@Query("UPDATE MyUser SET isActive=false where userId=:userId ")
	void deleteUser(@Param("userId") Integer userId);
	

}
