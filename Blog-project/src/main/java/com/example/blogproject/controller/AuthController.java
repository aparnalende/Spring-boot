package com.example.blogproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogproject.entities.User;
import com.example.blogproject.exceptions.ApiExceptions;
import com.example.blogproject.payloads.JwtAuthRequest;
import com.example.blogproject.payloads.UserDTO;
import com.example.blogproject.repository.UserRepo;
import com.example.blogproject.security.JwtAuthResponse;
import com.example.blogproject.security.JwtTokenHelper;
import com.example.blogproject.services.UserService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto) {
		UserDTO registeredUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDTO>(registeredUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> loginApi(@RequestBody JwtAuthRequest request) {
		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetail = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		Optional<User> user=this.userRepo.findUserByEmail(request.getUsername());
		System.out.println("\nUser info"+user);
		
		String token = this.jwtTokenHelper.generateToken(userDetail);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
	
	
	
	user.ifPresent(u -> {			
		 System.out.println("Name is " + u.getId());
		 response.setId(u.getId());
		 response.setEmail(u.getEmail());
		 response.setUser(u.getName());
		});
	
	
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {
			this.authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {
			System.out.println("Invalid credentials!!");
			throw new ApiExceptions("Invalid username or password!!");
		}

	}
}
