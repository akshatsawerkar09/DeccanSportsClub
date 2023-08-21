package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Batches;
import com.app.model.EnrolledSports;

@Service
@Transactional
public interface IManagerService {

	Batches getBatchById(int batchId);

	void deleteBatchesById(int batchId);

	Batches updateBatch(Batches batches);

	Batches addBatches(Batches batches);

	EnrolledSports approveUser(int enrolledId);

	EnrolledSports rejectUser(int enrolledId);

	List<Batches> getManagerBatches(int sportsId);

	List<EnrolledSports> getEnrolledSportsById(int sportsId);

}
