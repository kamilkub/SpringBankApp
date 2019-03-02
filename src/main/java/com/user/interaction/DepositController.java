package com.user.interaction;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.interaction.Model.User;
import com.user.interaction.Service.AccountService;
import com.user.interaction.Service.UserService;

@Controller
public class DepositController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	

	@GetMapping("/menu/make/savingsDeposit")
	public String getSavDespoit(Model model) {
		
		model.addAttribute("savings", true);
		
		
		return "deposit";
		
	}
	
	@GetMapping("/menu/make/mainDeposit")
	public String getMainDespoit(Model model) {
		
		
		model.addAttribute("main", true);
		
		
		return "deposit";
		
	}
	
	//// ---------------------- POST MAPPINGS ------------------------------ ////
	
	
	
	@PostMapping("/menu/make/savingsDeposit")
	public String makeSavDeposit(@RequestParam("amount") BigDecimal amount, Model model) throws InterruptedException {
		

		
		model.addAttribute("available", true);
		
		
		if(amount == null) {
			Thread.sleep(4000);
			model.addAttribute("cannotBeNull", true);
			return "redirect:/menu/make/savingsDeposit";
		}
		
		if(!isBetween(amount)) {
			Thread.sleep(4000);
			model.addAttribute("cannotBeNull", true);
			return "redirect:/menu/make/savingsDeposit";
		} else {
			
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findByLogin(auth.getName());
		
		if(accountService.savAccountDepositBalance(user.getSavingsAccount().getAccountNumber(), amount)) {
			Thread.sleep(4000);
			model.addAttribute("successDeposit", true);
			return "redirect:/menu/make/savingsDeposit";
		}else {
			Thread.sleep(4000);
			model.addAttribute("failureDeposit", true);
			return "redirect:/menu/make/savingsDeposit";
		}
	}
	
		
	}
	
	@PostMapping("/menu/make/mainDeposit")
	public String makeMainDespoit(@RequestParam("amount") BigDecimal amount, Model model) throws InterruptedException {
		
		
			
		model.addAttribute("available", true);
		
		
		if(amount == null) {
			model.addAttribute("cannotBeNull", true);
			Thread.sleep(4000);
			return "redirect:/menu/make/mainDeposit";
		}
		
		if(!isBetween(amount)) {
			
			model.addAttribute("cannotBeNull", true);
			Thread.sleep(4000);
			return "redirect:/menu/make/mainDeposit";
		}else {
			
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findByLogin(auth.getName());
		
		if(accountService.mAccountDepositBalance(user.getMainAccount().getAccountNumber(), amount)) {
			model.addAttribute("successDeposit", true);
			Thread.sleep(4000);
			return "redirect:/menu/make/mainDeposit";
		}else {
			model.addAttribute("failureDeposit", true);
			Thread.sleep(4000);
			return "redirect:/menu/make/mainDeposit";
		}
	}
		
	
	}
	
	
	/// --- METHODS --- ///
	
	
	public boolean isAuthenticated(){

	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();

	   }
	
	public static boolean isBetween(BigDecimal amount) {
		return amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(BigDecimal.valueOf(500)) < 0;
	}
	
	
	
	
}

