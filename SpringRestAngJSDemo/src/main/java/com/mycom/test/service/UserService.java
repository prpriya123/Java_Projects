package com.mycom.test.service;

import java.util.List;

import com.mycom.test.model.UserVO;



public interface UserService {
	
	UserVO findById(long id);
	
	UserVO findByName(String name);
	
	void saveUser(UserVO user);
	
	void updateUser(UserVO user);
	
	void deleteUserById(long id);

	List<UserVO> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(UserVO user);

	List<UserVO> submitUsers();
	
	List<UserVO> submitUsersErr() throws Exception;
	
}
