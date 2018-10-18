package com.disney.dream.user;

public class UserBuilder {
	
	private User user = new User();
	
	public UserBuilder id(Integer id) {
		user.setId(id);
		return this;
	}
	
	public UserBuilder firstName(String firstName) {
		user.setFirstName(firstName);
		return this;
	}
	
	public UserBuilder lastName(String lastName) {
		user.setLastName(lastName);
		return this;
	}
	
	public UserBuilder password(String password) {
		user.setPassword(password);
		return this;
	}
	
	public User build() {
		return user;
	}

	
}
