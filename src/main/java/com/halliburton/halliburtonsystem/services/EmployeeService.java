package com.halliburton.halliburtonsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll(){
		List<Employee> list = repository.findAll();
		
		List<EmployeeDTO> listDTO = list.stream().map(x -> new EmployeeDTO(x))
				.collect(Collectors.toList());
		return (listDTO);
	}
	
	private void copyDtoToEntity(EmployeeDTO dto, Employee entity) {
		entity.setName(dto.getName());
		entity.setRole(dto.getRole());
		entity.setCompany(dto.getCompany());
	}
	
	
}
