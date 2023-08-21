package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EnrolledSportsRepository;
import com.app.dao.UserRepository;
import com.app.model.EnrolledSports;
import com.app.model.Users;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private EnrolledSportsRepository enrolledSportsRepo;

	@Override
	public Users getUserById(int userId) {

		return userRepo.findById(userId).get();
	}

	@Override
	public void deleteUserById(int userId) {

		userRepo.deleteById(userId);
	}

	@Override
	public Users updateUser(Users users) {
		return userRepo.save(users);
	}

	@Override
	public Users registerUser(Users users) {

		return userRepo.save(users);
	}

	@Override
	public Users authenticateUser(String userName, String password) {

		return userRepo.findUsersByUserNameAndPassword(userName, password);
	}

	@Override
	public int loginCount(String userName) {
		Users users = userRepo.findByUserName(userName);
		return users.getLoginAttempt();
	}

	@Override
	public Users updatePassword(Users users, String newPassword) {
		Users user = userRepo.findUsersByEmailAndPassword(users.getEmail(), users.getPassword());
		user.setPassword(newPassword);
		userRepo.save(user);
		return user;
	}

	@Override
	public Users findUserByEmailAndPassword(String email, String password) {

		return userRepo.findUsersByEmailAndPassword(email, password);
	}

	@Override
	public List<EnrolledSports> findEnrolledSportsBySportsId(int sportsId) {

		return enrolledSportsRepo.findBySportsId(sportsId);
	}

	@Override
	public EnrolledSports userEnrolledSports(EnrolledSports enrolledSports) {

		return enrolledSportsRepo.save(enrolledSports);
	}

	@Override
	public EnrolledSports approveUser(int enrolledId) {
		EnrolledSports enrolledSports = enrolledSportsRepo.findByEnrolledId(enrolledId);
		enrolledSports.setEnrolledStatus(1);
		enrolledSportsRepo.save(enrolledSports);
		return enrolledSports;
	}

	@Override
	public Users checkUserName(String userName) {
		Users users = userRepo.findByUserName(userName);
		return users;
	}

	@Override
	public void incrementCount(String userName) {
		Users users = userRepo.findByUserName(userName);
		int count = users.getLoginAttempt();
		users.setLoginAttempt(count + 1);
		userRepo.save(users);
	}

	@Override
	public void setLoginCountZero(String userName) {
		Users users = userRepo.findByUserName(userName);
		users.setLoginAttempt(0);
		userRepo.save(users);

	}

}
