package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Batches;
import com.app.model.EnrolledSports;
import com.app.model.Membership;
import com.app.model.Sports;
import com.app.model.Users;

@Service
@Transactional
public interface IAdminService {

	List<Users> getAllUsers();

	List<EnrolledSports> getAllEnrolledSports();

	List<Membership> getAllMembershipDetails();

	Users addManager(Users users);

	List<Users> getAllManagers();

	Sports getSportsBySportsId(int sportsId);

	void deleteSportsById(int sportsId);

	Sports updateSports(Sports sports);

	Sports addSports(Sports sports);

	List<Sports> getAllSports();

	List<Batches> getAllBatches();

	

	List<Users> lockedAccounts();

	String unlockAccounts(String userName);

}
