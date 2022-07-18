package com.csmtech.service;

import java.util.List;

import com.csmtech.model.MyUser;

public interface MyUserService {
MyUser saveUser(MyUser myUser);
List<MyUser> getAllActiveUser();
void deleteUser(Integer userId);
MyUser getUserById(Integer userId);
}
