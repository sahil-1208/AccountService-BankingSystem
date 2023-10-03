package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.enums.Status;
import com.learning.model.AccountRequest;
import com.learning.model.AccountResponse;
import com.learning.service.AccountService;




@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService userService;
	
	@PostMapping
	public AccountResponse createNewAccount(@RequestBody AccountRequest accountRequest) {
		return userService.create(accountRequest);
	}

	@GetMapping("/{id}")
	public AccountResponse getExistingAccountById(@PathVariable Long id) {
		return userService.findAccountById(id);
	}
	
	@PutMapping("/{id}")
	public AccountResponse updateExistingAccountById(@PathVariable Long id, @RequestBody AccountRequest accountRequest) {
		return userService.update(id, accountRequest);
	}
	
	@DeleteMapping("/{id}")
	public Status deleteExistingAccountById(@PathVariable Long id) {
		return userService.deleteAccountById(id);	
	}

}
