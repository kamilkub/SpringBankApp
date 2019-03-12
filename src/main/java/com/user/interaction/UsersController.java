package com.user.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.interaction.Model.MainTransactions;
import com.user.interaction.Model.SavingsTransactions;
import com.user.interaction.Model.User;
import com.user.interaction.Service.TransactionService;
import com.user.interaction.Service.UserService;

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
