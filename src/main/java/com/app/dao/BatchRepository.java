package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Batches;

@Repository
public interface BatchRepository extends JpaRepository<Batches, Integer> {

	List<Batches> findBySportsId(int sportId);

}
