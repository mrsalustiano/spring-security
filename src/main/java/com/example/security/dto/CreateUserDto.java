package com.example.security.dto;

import com.example.security.enuns.RoleName;

public record CreateUserDto(
		String email,
        String password,
        RoleName role
		) {

}
