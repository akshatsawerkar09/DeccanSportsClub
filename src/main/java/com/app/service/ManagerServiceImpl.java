package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BatchRepository;
import com.app.dao.EnrolledSportsRepository;
import com.app.model.Batches;
import com.app.model.EnrolledSports;

@Service
@Transactional
public class ManagerServiceImpl implements IManagerService {

	@Autowired
	private BatchRepository batchRepo;

	@Autowired
	private EnrolledSportsRepository enrolledSportsRepo;

	@Override
	public Batches getBatchById(int batchId) {

		return batchRepo.findById(batchId).get();
	}

	@Override
	public void deleteBatchesById(int batchId) {

		batchRepo.deleteById(batchId);
	}

	@Override
	public Batches updateBatch(Batches batches) {

		return batchRepo.save(batches);
	}

	@Override
	public Batches addBatches(Batches batches) {

		return batchRepo.save(batches);
	}

	@Override
	public EnrolledSports approveUser(int enrolledId) {
		EnrolledSports enrolledSports = enrolledSportsRepo.findByEnrolledId(enrolledId);
		enrolledSports.setEnrolledStatus(1);
		return enrolledSportsRepo.save(enrolledSports);
	}

	@Override
	public EnrolledSports rejectUser(int enrolledId) {
		EnrolledSports enrolledSports = enrolledSportsRepo.findByEnrolledId(enrolledId);
		enrolledSports.setEnrolledStatus(2);
		return enrolledSportsRepo.save(enrolledSports);
	}

	@Override
	public List<Batches> getManagerBatches(int sportsId) {
		List<Batches> batchesList = batchRepo.findBySportsId(sportsId);
		return batchesList;
	}

	@Override
	public List<EnrolledSports> getEnrolledSportsById(int sportsId) {
		List<EnrolledSports> enrolledSportsList = enrolledSportsRepo.findBySportsId(sportsId);
		return enrolledSportsList;
	}

}
