package com.halliburton.halliburtonsystem.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.halliburton.halliburtonsystem.dto.EmployeeDTO;
import com.halliburton.halliburtonsystem.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeResource {

	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll(){
		
		List<EmployeeDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list); 
	}
	
}
