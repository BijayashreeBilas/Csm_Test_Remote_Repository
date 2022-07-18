package com.csmtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csmtech.model.MyUser;
import com.csmtech.service.MyRoleService;
import com.csmtech.service.MyUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private MyUserService myUserService;
	@Autowired
	private MyRoleService myRoleService;
	
	
	@GetMapping("/getUserForm")
	public String getUserForm(Model model) {
		
		model.addAttribute("allroles" ,myRoleService.getAllRole());
		model.addAttribute("AllActiveList", myUserService.getAllActiveUser());
		return "userRegistration";
		
	}
	@PostMapping("/saveuserForm")
	public String saveUserForm(@ModelAttribute ("MyUser")MyUser myUser) {
		myUserService.saveUser(myUser);
		return "redirect:./getUserForm";
		
	}
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		
		myUserService.deleteUser(userId);
		return "redirect:./getUserForm";
		
	}
	@GetMapping("/updateUser")
	public String updateUser(Model model,@RequestParam("userId") Integer userId) {
		
		model.addAttribute("AllActiveList",myUserService.getAllActiveUser());
		model.addAttribute("myUser", myUserService.getUserById(userId));
		model.addAttribute("allroles" ,myRoleService.getAllRole());
		
		return "userRegistration";
	}


}
