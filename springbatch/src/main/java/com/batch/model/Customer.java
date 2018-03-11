package com.batch.model;

public class Customer {

	private String id;
	private String name;
	private String role;

	public Customer(String id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Customer() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
