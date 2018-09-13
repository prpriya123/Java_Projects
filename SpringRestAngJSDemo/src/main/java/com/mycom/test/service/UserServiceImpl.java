package com.mycom.test.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.test.dao.UserDao;
import com.mycom.test.entity.UserEntity;
import com.mycom.test.model.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	private static final AtomicLong counter = new AtomicLong();

	private static List<UserVO> users;

	static {
		users = populateDummyUsers();
	}

	public List<UserVO> findAllUsers() {
		return users;
	}

	// @Transactional
	public void submitUser(UserVO user) throws Exception {
		userDao.submitUsers(convertModelToEntity(user));
	}

	public List<UserVO> submitUsers() {
		final List<UserVO> tempUsers =users;
		for (UserVO user : tempUsers) {
			try {
				submitUser(user);
			} catch (Exception e) {
				System.err.println("Error in User Info" + user.getUsername());
				System.err.println("Error msg: " + e.getMessage());
			}
		}
		deleteAllUsers();
		return users;
	}

	// @Transactional
	@Override
	public List<UserVO> submitUsersErr() throws Exception {
		try {
			userDao.submitUsersErr(convertModelToEntity(users));
		} catch (Exception e) {
			System.err.println("Error in User Info");
			deleteAllUsers();
			System.err.println("Error msg: " + e.getMessage());
			throw new Exception("Error in given data");
		} 
		deleteAllUsers();
		return users;
	}

	public UserVO findById(long id) {
		for (UserVO user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public UserVO findByName(String name) {
		for (UserVO user : users) {
			if (user.getUsername().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	public void saveUser(UserVO user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(UserVO user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {

		for (Iterator<UserVO> iterator = users.iterator(); iterator.hasNext();) {
			UserVO user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isUserExist(UserVO user) {
		return findByName(user.getUsername()) != null;
	}

	public void deleteAllUsers() {
		users.clear();
	}

	private static List<UserVO> populateDummyUsers() {
		List<UserVO> users = new ArrayList<UserVO>();
		users.add(new UserVO(counter.incrementAndGet(), "Yamini", "NY", "sam@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(), "Sandy", "ALBAMA", "tomy@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(), "Kelly", "NEBRASKA", "kelly@abc.com"));
		return users;
	}

	private UserEntity convertModelToEntity(UserVO inUser) {
		UserEntity user = new UserEntity();
		user.setUsername(inUser.getUsername());
		user.setEmail(inUser.getEmail());
		user.setAddress(inUser.getAddress());
		return user;
	}

	private List<UserEntity> convertModelToEntity(final List<UserVO> inUsers) {
		List<UserEntity> users = new ArrayList<UserEntity>(0);
		if (null != inUsers && !inUsers.isEmpty()) {
			for (UserVO user : inUsers) {
				users.add(convertModelToEntity(user));
			}
		}
		return users;
	}

}
