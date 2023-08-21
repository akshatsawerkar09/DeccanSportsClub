package com.app.controller;

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

import com.app.model.Users;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {

	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in admin ctor " + getClass().getName());
	}

	@GetMapping("/getUser/{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable int userId) {
		Users users = userService.getUserById(userId);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable int userId) {
		userService.deleteUserById(userId);
		return new ResponseEntity<>("User Delete Successfully", HttpStatus.OK);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<Users> updateUser(@RequestBody Users users) {
		Users user = userService.updateUser(users);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/registerUser")
	public ResponseEntity<Users> regsiterUser(@RequestBody Users users) {
		Users user = userService.registerUser(users);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/authenticateUser")
	public ResponseEntity<String> authenticateUser(@RequestParam String userName, @RequestParam String password)
			throws Exception {
		Users users = userService.checkUserName(userName);
		if(users!=null)
		{
			int loginAttempt = userService.loginCount(userName);
			if (loginAttempt < 3) {
				Users user = userService.authenticateUser(userName, password);
				if (user != null) {
					userService.setLoginCountZero(userName);
					return new ResponseEntity<String>("login Successfull", HttpStatus.OK);
				} else {
					userService.incrementCount(userName);
					return new ResponseEntity<String>("Invalid Credendtials", HttpStatus.UNAUTHORIZED);
				}
			} else {
				return new ResponseEntity<String>("You have done 3 unsuccessfull login attempt your account has been locked ", HttpStatus.FORBIDDEN);
			
			}
		}
		else {
			return new ResponseEntity<String>("Invalid Credendtials", HttpStatus.UNAUTHORIZED);
		}
		

		// centralize exception @ControllerAdvice
		// enrolled sport by user id
		// membership by user id

	}

}
