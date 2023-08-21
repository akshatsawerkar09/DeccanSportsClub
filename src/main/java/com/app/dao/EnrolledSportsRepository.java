package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.EnrolledSports;

@Repository
public interface EnrolledSportsRepository extends JpaRepository<EnrolledSports, Integer> {

	EnrolledSports findByEnrolledId(int enrolledId);

	List<EnrolledSports> findBySportsId(int sportsId);
	
	

}
