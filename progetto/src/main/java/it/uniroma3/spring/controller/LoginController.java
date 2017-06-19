package it.uniroma3.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// controller to access the login page
@Controller
public class LoginController {

  // Login form
  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  // Login form with error
  @RequestMapping("/login-error.html")
  public String loginError(Model model) {
    model.addAttribute("loginError", true);
    return "login";
  }

  	@RequestMapping(value="/logout", method = RequestMethod.GET)
	  public String logoutPage (Model model, HttpServletRequest request, HttpServletResponse response) {
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){
	          model.addAttribute("logout", true);
	          new SecurityContextLogoutHandler().logout(request, response, auth);

	      }
	      return "login";
	  
	}
}
