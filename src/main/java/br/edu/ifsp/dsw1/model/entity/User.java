package br.edu.ifsp.dsw1.model.entity;

public class User {

	private String email;
	private String name;
	private String password;
	
	public User(String name, String email, String password) {
		init(name, email, password);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static boolean autenticate(User userFromSystem, String email, String password) {
		if (userFromSystem != null) {
			return password.equals(userFromSystem.password) && email.equals(userFromSystem.email);
		}
		return false;
	}
	
	private void init(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
}

