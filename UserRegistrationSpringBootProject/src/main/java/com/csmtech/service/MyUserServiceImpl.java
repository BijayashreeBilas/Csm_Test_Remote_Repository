package com.csmtech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.MyUser;
import com.csmtech.repository.MyUserRepository;

@Service
public class MyUserServiceImpl implements MyUserService {
	@Autowired
	private MyUserRepository myUserRepository;
	@Override
	public MyUser saveUser(MyUser myUser) {
		myUser.setIsActive(true);
		return myUserRepository.save(myUser);
	}
	@Override
	public List<MyUser> getAllActiveUser() {
		return myUserRepository.findAllActiveUser();
	}
	@Override
	public void deleteUser(Integer userId) {
	    myUserRepository.deleteUser(userId);
	}
	@Override
	public MyUser getUserById(Integer userId) {
		return myUserRepository.getById(userId) ;
	}
	
		

}
