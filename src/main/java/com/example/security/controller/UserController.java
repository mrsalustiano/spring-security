package com.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.dto.CreateUserDto;
import com.example.security.dto.LoginUserDto;
import com.example.security.dto.RecoveryJwtTokenDto;
import com.example.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	  @Autowired
	    private UserService userService;

	    @PostMapping("/login")
	    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
	        RecoveryJwtTokenDto token = userService.authenticateUser(loginUserDto);
	        return new ResponseEntity<>(token, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto createUserDto) {
	        userService.createUser(createUserDto);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }

	    @GetMapping("/test")
	    public ResponseEntity<String> getAuthenticationTest() {
	        return new ResponseEntity<>("Autenticado com sucesso", HttpStatus.OK);
	    }

	    @GetMapping("/test/customer")
	    public ResponseEntity<String> getCustomerAuthenticationTest() {
	        return new ResponseEntity<>("Cliente autenticado com sucesso", HttpStatus.OK);
	    }

	    @GetMapping("/test/administrator")
	    public ResponseEntity<String> getAdminAuthenticationTest() {
	        return new ResponseEntity<>("Administrador autenticado com sucesso", HttpStatus.OK);
	    }
	
}
