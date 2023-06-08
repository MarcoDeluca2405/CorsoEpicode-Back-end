package com.ProjectAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ProjectAuth.model.User;
import com.ProjectAuth.service.UtenteService;


@Controller
@RequestMapping("/api")
public class HomeController {
	
	@Autowired UtenteService us;
	
	@GetMapping
	public ModelAndView getPageHome() {
		ModelAndView page=new ModelAndView("home","userLogin",new User());
		return page;
	}
	
	
	@PostMapping
	public @ResponseBody String submitLogin(@ModelAttribute("userLogin") User login) {
		String u=us.loginUser(login);
		return u;
	}
	
}
