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

import com.app.model.EnrolledSports;
import com.app.model.Membership;
import com.app.model.Sports;
import com.app.model.Users;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	public AdminController() {
		System.out.println("in admin constructor " + getClass().getName());
	}

	@GetMapping("/getSports/{sportsId}")
	public ResponseEntity<Sports> getSportsBySportsId(@PathVariable int sportsId) {
		Sports sport = adminService.getSportsBySportsId(sportsId);
		return new ResponseEntity<>(sport, HttpStatus.OK);
	}

	@PostMapping("/addSports")
	public ResponseEntity<Sports> addSports(@RequestBody Sports sports) {
		Sports sport = adminService.addSports(sports);
		return new ResponseEntity<>(sport, HttpStatus.OK);
	}

	@DeleteMapping("/removeSports/{sportsId}")
	public ResponseEntity<String> removeSportsById(@PathVariable int sportsId) {
		adminService.deleteSportsById(sportsId);
		return new ResponseEntity<>("Sports Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/updateSports")
	public ResponseEntity<Sports> updateSports(@RequestBody Sports sports) {
		Sports sport = adminService.updateSports(sports);
		return new ResponseEntity<>(sport, HttpStatus.OK);
	}

	@GetMapping("/getAllSports")
	public ResponseEntity<List<Sports>> getAllSports() {
		List<Sports> sportsList = adminService.getAllSports();
		return new ResponseEntity<>(sportsList, HttpStatus.OK);
	}

	@GetMapping("/userDetails")
	public ResponseEntity<List<EnrolledSports>> getEnrolledUsers() {
		return new ResponseEntity<List<EnrolledSports>>(adminService.getAllEnrolledSports(), HttpStatus.OK);
	}

	@GetMapping("/membershipDetails")
	public ResponseEntity<List<Membership>> getAllMembershipDetails() {
		return new ResponseEntity<List<Membership>>(adminService.getAllMembershipDetails(), HttpStatus.OK);
	}

	@PostMapping("/assignManager")
	public ResponseEntity<Users> assignManager(@RequestBody Users users) {
		Users user = adminService.addManager(users);
		return new ResponseEntity<Users>(adminService.addManager(user), HttpStatus.OK);
	}

	@GetMapping("/listLockedAccounts")
	public ResponseEntity<List<Users>> accounts() {
		return new ResponseEntity<List<Users>>(adminService.lockedAccounts(), HttpStatus.OK);
	}

	@PutMapping("/unlockAccounts")
	public ResponseEntity<String> unlockAccounts(@RequestParam String userName) {
		return new ResponseEntity<String>(adminService.unlockAccounts(userName), HttpStatus.OK);
	}

}
