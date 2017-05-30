package com.example.demo.user;

import javax.servlet.http.HttpSession;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bankAdmin.AdminService;

@RestController
@RequestMapping("/user")
public class UserController {
	private HttpSession httpSession;
	private AdminService adminService;

	@Autowired
	public UserController(final HttpSession httpSession,AdminService adminService) {
		this.httpSession = httpSession;
		this.adminService = adminService;
	}
	
	@PostMapping(path = "/logIn")
	@ResponseStatus(HttpStatus.OK)
	public User logIn(@RequestBody User userInput) {
		User user = null;
		if (adminService.findOneByMailAndPassword(userInput.getMail(), userInput.getPassword()) != null) {
			user = adminService.findOneByMailAndPassword(userInput.getMail(), userInput.getPassword());
		}
		if (user != null) {
			httpSession.setAttribute("user", user);
		}
		return user;
	}

	@GetMapping(path = "/logOut")
	public void logOut() {
		httpSession.invalidate();
	}
}
