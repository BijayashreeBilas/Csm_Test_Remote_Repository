package com.csmtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.model.MyRole;

@Repository
public interface MyRoleRepository extends JpaRepository<MyRole, Integer> {

}
