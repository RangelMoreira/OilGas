package com.halliburton.halliburtonsystem.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping
	public ResponseEntity<Page<EmbarkDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "begin", defaultValue = "") String begin,
			@RequestParam(value = "end", defaultValue = "") String end) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<EmbarkDTO> list = service.find(begin, end, pageRequest);

		return ResponseEntity.ok().body(list);

	}
}
