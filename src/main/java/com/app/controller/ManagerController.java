package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Batches;
import com.app.model.EnrolledSports;
import com.app.model.Users;
import com.app.service.IManagerService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/manager")
@CrossOrigin("http://localhost:4200/")
public class ManagerController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IManagerService managerService;

	public ManagerController() {
		System.out.println("in manager constructor " + getClass().getName());
	}

	@GetMapping("/getBatches/{batchId}")
	public ResponseEntity<Batches> getBatchById(@PathVariable int batchId) {
		Batches batches = managerService.getBatchById(batchId);
		return new ResponseEntity<>(batches, HttpStatus.OK);
	}

	@PostMapping("/addBatch")
	public ResponseEntity<Batches> addBatches(@RequestBody Batches batches) {
		Batches batch = managerService.addBatches(batches);
		return new ResponseEntity<>(batch, HttpStatus.OK);
	}

	@DeleteMapping("/removeBatches/{batchId}")
	public ResponseEntity<String> removeBatchesByID(@PathVariable int batchId) {
		managerService.deleteBatchesById(batchId);
		return new ResponseEntity<>("Batch Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/updateBatches")
	public ResponseEntity<Batches> updateBatches(@RequestBody Batches batches) {
		Batches batch = managerService.updateBatch(batches);
		return new ResponseEntity<>(batch, HttpStatus.OK);
	}

//	@GetMapping("/getAllBatches")
//	public ResponseEntity<List<Batches>> getAllBatches() {
//		List<Batches> batchesList = managerService.getAllBatches();
//		return new ResponseEntity<>(batchesList, HttpStatus.OK);
//	}

	// get batches by sportsID upar wala nahi chaiye
	// price ke crud operation by sports id karne ka

	@GetMapping("/getMangerBatches")
	public ResponseEntity<List<Batches>> getManagerBatches(@RequestParam int sportsId) {
		List<Batches> batchesList = managerService.getManagerBatches(sportsId);
		return new ResponseEntity<List<Batches>>(batchesList, HttpStatus.OK);
	}

	@PutMapping("/updatePassword")
	public ResponseEntity<Users> updatePassword(@RequestBody Users users, @RequestParam String newPassword) {
		Users user = userService.findUserByEmailAndPassword(users.getEmail(), users.getPassword());
		if (user != null) {
			Users updatedUser = userService.updatePassword(users, newPassword);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

	}

	@PutMapping("/approveUser/{enrolledId}")
	public ResponseEntity<EnrolledSports> approveUser(@PathVariable int enrolledId) {
		EnrolledSports enrolledSport = managerService.approveUser(enrolledId);
		return new ResponseEntity<EnrolledSports>(enrolledSport, HttpStatus.OK);

	}

	@PutMapping("/rejectUser/{enrolledId}")
	public ResponseEntity<EnrolledSports> rejectUser(@PathVariable int enrolledId) {
		EnrolledSports enrolledSport = managerService.rejectUser(enrolledId);
		return new ResponseEntity<EnrolledSports>(enrolledSport, HttpStatus.OK);

	}

	@GetMapping("/getEnrolledSports/{sportsId}")
	public ResponseEntity<List<EnrolledSports>> getEnrolledSportsById(@PathVariable int sportsId) {

		List<EnrolledSports> enrolledSportsList = managerService.getEnrolledSportsById(sportsId);
		return new ResponseEntity<>(enrolledSportsList, HttpStatus.OK);
	}

}
