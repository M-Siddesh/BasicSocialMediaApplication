package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	@Autowired
	private UserDAOService service;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) throws UserNotFoundException {
		User user = service.findOne(id);
		
		if(user == null)
			throw new UserNotFoundException("id:"+id);
		
		return user;
	}
	
	@PostMapping("/addUsers")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.addUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).
				toUri();
		
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) throws UserNotFoundException {
		boolean deleted = service.deleteUserById(id);
		
		if(!deleted)
			throw new UserNotFoundException("id: "+id);
	}
}
