package com.example.security.dto;

import java.util.List;

import com.example.security.entity.Role;

public record RecoveryUserDto(
		
			Long id,
	        String email,
	        List<Role> roles
		
		) {

}
