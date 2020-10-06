package com.user.interaction.controller;

import com.user.interaction.model.User;
import com.user.interaction.service.AccountService;
import com.user.interaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class DepositController {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@GetMapping("/menu/make/savingsDeposit")
	public String getSavDespoit(Model model) {

		model.addAttribute("savings", true);
		
        model.addAttribute("available", true);
		
		model.addAttribute("null", true);

		return "deposit";

	}

	@GetMapping("/menu/make/mainDeposit")
	public String getMainDespoit(Model model) {

		model.addAttribute("main", true);
		
		model.addAttribute("available", true);
		
		model.addAttribute("null", true);

		return "deposit";

	}

	//// ---------------------- POST MAPPINGS ------------------------------ ////

	@PostMapping("/menu/make/savingsDeposit")
	public String makeSavDeposit(@RequestParam("amount") BigDecimal amount, Model model) throws InterruptedException {


		

		if (amount == null) {
			Thread.sleep(3000);
			model.addAttribute("savings", true);
			model.addAttribute("failure", true);
			return "deposit";
		}

		if (!isBetween(amount)) {
			Thread.sleep(3000);
			model.addAttribute("savings", true);
			model.addAttribute("failure", true);
			return "deposit";
		} else {

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			User user = userService.findByLogin(auth.getName());

			if (accountService.savAccountDepositBalance(user.getSavingsAccount().getAccountNumber(), amount)) {
				Thread.sleep(3000);
				model.addAttribute("savings", true);
				model.addAttribute("success", true);
				return "deposit";
			} else {
				Thread.sleep(3000);
				model.addAttribute("savings", true);
				model.addAttribute("failure", true);
				return "deposit";
			}
		}

	}

	@PostMapping("/menu/make/mainDeposit")
	public String makeMainDespoit(@RequestParam("amount") BigDecimal amount, Model model) throws InterruptedException {


		if (amount == null) {
			Thread.sleep(3000);
			model.addAttribute("main", true);
			model.addAttribute("failure", true);
			return "deposit";
		}
		
		
		if (!isBetween(amount)) {
			Thread.sleep(3000);
			model.addAttribute("main", true);
			model.addAttribute("failure", true);
			return "deposit";
		} else {

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			User user = userService.findByLogin(auth.getName());

			if (accountService.mAccountDepositBalance(user.getMainAccount().getAccountNumber(), amount)) {
				Thread.sleep(3000);
				model.addAttribute("main", true);
				model.addAttribute("success", true);
				return "deposit";
			} else {
				Thread.sleep(3000);
				model.addAttribute("main", true);
				model.addAttribute("failure", true);
				return "deposit";
			}
		}

	}

	/// --- METHODS --- ///

	public boolean isAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
				&& authentication.isAuthenticated();

	}

	public static boolean isBetween(BigDecimal amount) {
		return amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(BigDecimal.valueOf(500)) < 0;
	}

}
