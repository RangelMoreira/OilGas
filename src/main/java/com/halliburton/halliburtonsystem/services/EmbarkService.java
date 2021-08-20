package com.halliburton.halliburtonsystem.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.halliburton.halliburtonsystem.dto.EmbarkDTO;
import com.halliburton.halliburtonsystem.entities.Embark;
import com.halliburton.halliburtonsystem.entities.Employee;
import com.halliburton.halliburtonsystem.repositories.EmbarkRepository;
import com.halliburton.halliburtonsystem.services.exceptions.BusinessException;

@Service
public class EmbarkService {

	@Autowired
	private EmbarkRepository repository;

	@Transactional()
	public EmbarkDTO insert(EmbarkDTO dto) throws Exception {

		if (dto.getEnd().isAfter(dto.getBegin().plusDays(14))) {
			throw new BusinessException("It is not possible to stay on board for more than 14 days");
		}
		
		Embark lastEmbark = repository.findLastEmbark(dto.getEmployee().getId());
		
		if (dto.getBegin().isBefore(lastEmbark.getEnd().plusDays(7))) {
			throw new BusinessException("At least 7 days off is required for the next shipment");
		}
		
		Embark entity = new Embark();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EmbarkDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<EmbarkDTO> find(String begin, String end, PageRequest pageRequest) {
		if (begin.isEmpty() || end.isEmpty()) {
			Page<Embark> page = repository.findAll(pageRequest);
			return page.map(x -> new EmbarkDTO(x));
		} else {
			Page<Embark> page = repository.find(convertDate(begin), convertDate(end), pageRequest);
			return page.map(x -> new EmbarkDTO(x));
		}

	}

	private void copyDtoToEntity(EmbarkDTO dto, Embark entity) {
		entity.setBegin(dto.getBegin());
		entity.setEnd(dto.getEnd());
		Employee employee = new Employee();
		employee.setId(dto.getEmployee().getId());
		entity.setEmployee(employee);
	}

	public LocalDate convertDate(String stringDate) {

		String[] dabaseDate = stringDate.split("/");

		LocalDate date = LocalDate.of(Integer.parseInt(dabaseDate[2]), Integer.parseInt(dabaseDate[1]),
				Integer.parseInt(dabaseDate[0]));

		return date;
	}

}
