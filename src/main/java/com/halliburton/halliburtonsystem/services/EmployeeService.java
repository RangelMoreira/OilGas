package com.halliburton.halliburtonsystem.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halliburton.halliburtonsystem.dto.EmployeeDTO;
import com.halliburton.halliburtonsystem.entities.Employee;
import com.halliburton.halliburtonsystem.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		copyDtoToEntity( dto,  entity);
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}
	
	private void copyDtoToEntity(EmployeeDTO dto, Employee entity) {
		entity.setName(dto.getName());
		entity.setRole(dto.getRole());
		entity.setCompany(dto.getCompany());
	}

}
