package com.user.interaction;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkController {

	
	@RequestMapping("/")
	public String index(HttpServletResponse response, HttpServletRequest request,Model model){
		
		if(isAuthenticated()) {
			
			return "redirect:/menu";
			
		}
		
		Cookie cookieUser = new Cookie("visiterCookie", "aklxvdstydm");
		
		response.addCookie(cookieUser);
		
		
		if(request.isRequestedSessionIdValid()) {
			model.addAttribute("condition", true);
		}
		
		
		return "index";
	}
	
	public boolean isAuthenticated(){

	       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	       return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();

	   }
	

	
}
