package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findUsersByUserNameAndPassword(String userName, String password);

	Users findByUserName(String userName);

	Users findUsersByEmailAndPassword(String email, String password);

	List<Users> findByUserRole(String userRole);

	List<Users> findByLoginAttempt(int loginAttempts);//loginAttempt

}
