package com.halliburton.halliburtonsystem.services;

import java.time.temporal.ChronoUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.halliburton.halliburtonsystem.dto.EmbarkDTO;
import com.halliburton.halliburtonsystem.entities.Embark;
import com.halliburton.halliburtonsystem.entities.Employee;
import com.halliburton.halliburtonsystem.repositories.EmbarkRepository;

@Service
public class EmbarkService {

	@Autowired
	private EmbarkRepository repository;

	@Transactional()
	public EmbarkDTO insert(EmbarkDTO dto) throws Exception {

		if (dto.getEnd().isAfter(dto.getBegin().plus(14, ChronoUnit.DAYS))) {
			throw new Exception("Não é possível ficar mais de 14 dias embarcado");
		}

		Embark entity = new Embark();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EmbarkDTO(entity);
	}

	private void copyDtoToEntity(EmbarkDTO dto, Embark entity) {
		entity.setBegin(dto.getBegin());
		entity.setEnd(dto.getEnd());
		Employee employee = new Employee();
		employee.setId(dto.getEmployee().getId());
		entity.setEmployee(employee);
	}

}
