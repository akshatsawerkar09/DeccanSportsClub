package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BatchRepository;
import com.app.dao.EnrolledSportsRepository;
import com.app.dao.MembershipRepository;
import com.app.dao.SportsRepository;
import com.app.dao.UserRepository;
import com.app.model.Batches;
import com.app.model.EnrolledSports;
import com.app.model.Membership;
import com.app.model.Sports;
import com.app.model.Users;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private EnrolledSportsRepository enrolledSportsRepo;
	@Autowired
	private MembershipRepository membershipRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SportsRepository sportsRepo;
	@Autowired
	private BatchRepository batchRepo;

	@Override
	public List<Users> getAllUsers() {
		// users where usere role = ?
		List<Users> usersList = userRepo.findByUserRole("USER");
		return usersList;
	}

	@Override
	public List<EnrolledSports> getAllEnrolledSports() {

		return enrolledSportsRepo.findAll();
	}

	@Override
	public List<Membership> getAllMembershipDetails() {

		return membershipRepo.findAll();
	}

	@Override
	public Users addManager(Users users) {

		return userRepo.save(users);
	}

	@Override
	public List<Batches> getAllBatches() {

		return batchRepo.findAll();
	}

	@Override
	public Sports getSportsBySportsId(int sportsId) {

		return sportsRepo.findById(sportsId).get();
	}

	@Override
	public void deleteSportsById(int sportsId) {

		sportsRepo.deleteById(sportsId);
	}

	@Override
	public Sports updateSports(Sports sports) {

		return sportsRepo.save(sports);
	}

	@Override
	public Sports addSports(Sports sports) {

		return sportsRepo.save(sports);
	}

	@Override
	public List<Sports> getAllSports() {

		return sportsRepo.findAll();
	}

	@Override
	public List<Users> getAllManagers() {
		// TODO Auto-generated method stub where user role =manager
		List<Users> managerList = userRepo.findByUserRole("MANAGER");
		return managerList;
	}

	

	@Override
	public List<Users> lockedAccounts() {
		List<Users> lockedAccountList = userRepo.findByLoginAttempt(3);
		return lockedAccountList;
	}

	@Override
	public String unlockAccounts(String userName) {
		Users users = userRepo.findByUserName(userName);
		users.setLoginAttempt(0);
		userRepo.save(users);
		return "Account Unlocked";
	}

}
