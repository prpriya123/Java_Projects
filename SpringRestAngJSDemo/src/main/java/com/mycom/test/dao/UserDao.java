package com.mycom.test.dao;

import java.util.List;

import com.mycom.test.entity.UserEntity;




public interface UserDao {
	
	void submitUsers(UserEntity users) throws Exception;
	
	void submitUsersErr(final List<UserEntity> users) throws Exception;
	
	/*User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);*/

	
	
}
