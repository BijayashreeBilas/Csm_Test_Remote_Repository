package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.MyRole;
import com.csmtech.repository.MyRoleRepository;

@Service
public class MyRoleServiceImpl implements MyRoleService {
	@Autowired
	private MyRoleRepository myRoleRepository;

	@Override
	public List<MyRole> getAllRole() {
		return myRoleRepository.findAll();
	}

}
