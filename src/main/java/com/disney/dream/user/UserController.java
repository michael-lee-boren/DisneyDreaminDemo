package com.disney.dream.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping
	public List<User> getUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		userList.add(new UserBuilder().id(1).firstName("Michael").lastName("Boren").password("Dream").build());
		userList.add(new UserBuilder().id(2).firstName("Walt").lastName("Disney").password("Mickey").build());
		userList.add(new UserBuilder().id(3).firstName("Tinker").lastName("Bell").password("PixieDust").build());
		
		return userList;
		
	}
	
	@GetMapping("{id}")
	public User getUser(@PathVariable Integer id) {
		
		log.debug("User ID of [" + id + "] has been requested");
		return new UserBuilder().id(id).firstName("Mickey").lastName("Mouse").password("Minnie").build();
		
	}

}
