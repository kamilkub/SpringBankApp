package com.user.interaction.controller;

import com.user.interaction.model.Recipients;
import com.user.interaction.model.User;
import com.user.interaction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.math.BigDecimal;


@Controller
public class TransactionsController {
  
	
	@Autowired
	MeetingService meetingService;
	
	@Autowired
	TransactionService transService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	RecipientService recipService;
	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping("/meeting-del")
	public String deleteMapping(@RequestParam("id") long id) {
		
		meetingService.deleteById(id);
		
		return "redirect:/menu/appointments";
	}
	
	@GetMapping("/delete-recip")
	public String deleteRecipient(@RequestParam("id") long id) {
		
		transService.deleteById(id);
		
		return "redirect:/menu/recipients";
	}
	
	
	@PostMapping("/sendmoney")
	public String sendMoney(@Valid @ModelAttribute("recipient") Recipients recipient, @RequestParam("money") BigDecimal money, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		

		User user = userService.findByLogin(auth.getName());
		
		BigDecimal balance = user.getMainAccount().getAccountBalance();
		
		if(balance.compareTo(money) == 0 || balance.compareTo(money) > 0) {
		  if(user.getEmail() != recipient.getEmail() && user.getMainAccount().getAccountNumber() != recipient.getAccountNumber()) {
			accountService.sendMoneyToRecipient(recipient.getAccountNumber(), money, recipient.getDescription(), user.getMainAccount().getAccountNumber());
			recipient.setUser(user);
			recipService.addRecipient(recipient);
			return "redirect:/menu/accountstatus";
		  }else {
			  model.addAttribute("null", true);
			return "menu-templates/account";
		  }
		}else {
			model.addAttribute("null", true);
			return "menu-templates/account";
		}
		
		
		

	}
	
	
	
	
	
	
	
	
}
