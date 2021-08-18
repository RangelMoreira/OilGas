package com.halliburton.halliburtonsystem.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.halliburton.halliburtonsystem.dto.EmbarkDTO;
import com.halliburton.halliburtonsystem.services.EmbarkService;

@RestController
@RequestMapping(value = "/embark")
public class EmbarkResource {
	
	@Autowired
	private EmbarkService service;
	
	@PostMapping
	public ResponseEntity<EmbarkDTO> insert(@RequestBody EmbarkDTO dto) throws Exception {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}
}
