package com.example.demo.bankAdmin;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	private final AdminService adminService;
	private HttpSession httpSession;
	
	@Autowired
	public AdminController(final HttpSession httpSession,final AdminService adminService) {
		this.httpSession = httpSession;
		this.adminService = adminService;
	}
	
	@GetMapping("/checkRights")
	@ResponseStatus(HttpStatus.OK)
	public Admin checkRights() throws AuthenticationException {
		try {
			Admin admin = adminService.findOneById(((Admin) httpSession.getAttribute("user")).getId());
			return admin;
		} catch (Exception e) {
			throw new AuthenticationException("Forbidden.");
		}
	}
}
