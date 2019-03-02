package com.user.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.interaction.Model.User;
import com.user.interaction.Service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {


	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public Iterable<User> findAll() {
		
		return userService.findAll();
		
		
	}
}
