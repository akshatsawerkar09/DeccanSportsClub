package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Users;

@Repository
public interface AdminRepository extends JpaRepository<Users, Integer> {
	
	
	
	

}
