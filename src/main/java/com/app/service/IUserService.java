package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.EnrolledSports;
import com.app.model.Users;

@Service
@Transactional
public interface IUserService {

	Users getUserById(int userId);

	void deleteUserById(int userId);

	Users updateUser(Users users);

	Users registerUser(Users users);

	Users authenticateUser(String userName, String password);

	int loginCount(String userName);

	Users updatePassword(Users users, String newPassword);

	Users findUserByEmailAndPassword(String email, String password);

	List<EnrolledSports> findEnrolledSportsBySportsId(int sportsId);

	EnrolledSports approveUser(int enrolledId);

	EnrolledSports userEnrolledSports(EnrolledSports enrolledSports);

	Users checkUserName(String userName);

	void incrementCount(String userName);

	void setLoginCountZero(String userName);
	
	

}
