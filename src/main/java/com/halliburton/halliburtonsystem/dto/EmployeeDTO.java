package com.halliburton.halliburtonsystem.dto;

import java.io.Serializable;

import com.halliburton.halliburtonsystem.entities.Employee;

public class EmployeeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String role;
	private String company;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Long id, String name, String role, String company) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.company = company;
	}
	
	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		role = entity.getRole();
		company = entity.getCompany();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
