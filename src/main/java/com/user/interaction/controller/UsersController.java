package com.user.interaction.controller;

import com.user.interaction.model.MainTransactions;
import com.user.interaction.model.SavingsTransactions;
import com.user.interaction.model.User;
import com.user.interaction.service.TransactionService;
import com.user.interaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {


	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionService tranService;
	
	@GetMapping("/all")
	public Iterable<User> findAll() {
		
		return userService.findAll();
		
		
	}
	
	@GetMapping("/main")
	public Iterable<MainTransactions> giveAllMainTrans(){
		return tranService.findAllMain();
	}
	
	@GetMapping("/savin")
	public Iterable<SavingsTransactions> giveAllSavTrans(){
		return tranService.findAllSav();
	}
	
	
	
}
