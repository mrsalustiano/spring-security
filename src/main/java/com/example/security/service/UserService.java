package com.example.security.service;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.security.config.SecurityConfiguration;
import com.example.security.dto.CreateUserDto;
import com.example.security.dto.LoginUserDto;
import com.example.security.dto.RecoveryJwtTokenDto;
import com.example.security.entity.Role;
import com.example.security.entity.User;
import com.example.security.repository.UserRepository;

@Service
public class UserService {

	   @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtTokenService jwtTokenService;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private SecurityConfiguration securityConfiguration;

	    // Método responsável por autenticar um usuário e retornar um token JWT
	    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
	        // Cria um objeto de autenticação com o email e a senha do usuário
	        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

	        // Autentica o usuário com as credenciais fornecidas
	        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

	        // Obtém o objeto UserDetails do usuário autenticado
	        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

	        // Gera um token JWT para o usuário autenticado
	        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
	    }

	    // Método responsável por criar um usuário
	    public void createUser(CreateUserDto createUserDto) {

	        // Cria um novo usuário com os dados fornecidos
	        User newUser = User.builder()
	                .email(createUserDto.email())
	                // Codifica a senha do usuário com o algoritmo bcrypt
	                .password(securityConfiguration.passwordEncoder().encode(createUserDto.password()))
	                // Atribui ao usuário uma permissão específica
	                .roles(List.of(Role.builder().name(createUserDto.role()).build()))
	                .build();

	        // Salva o novo usuário no banco de dados
	        userRepository.save(newUser);
	    }
}
