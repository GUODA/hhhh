package com.demo.service;

import com.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

	int insertUser(User user);
	List<User> userList();
	void deleteById(int id);
	User findById(int id);
	void updateUser(User user);
	User findByAccount(String account);
	Set<String> getRolesName();
}
