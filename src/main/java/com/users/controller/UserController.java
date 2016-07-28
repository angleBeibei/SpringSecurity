package com.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.users.dao.UserDaoImpl;
import com.users.model.User;
import com.users.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserValidator userValidator;
	private UserDaoImpl userDaoImpl;
	@Autowired
	public UserController(UserDaoImpl userDaoImpl){
		this.userDaoImpl=userDaoImpl;
	}
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String registration(Model model){
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm,BindingResult bindingResult,Model model){
		userValidator.validate(userForm,bindingResult);
		
		if(bindingResult.hasErrors()){
			return "registration";
		}
		System.out.println(userForm.getUsername());
		userDaoImpl.save(userForm);
		return "redirect:/secure/";
	}
}
