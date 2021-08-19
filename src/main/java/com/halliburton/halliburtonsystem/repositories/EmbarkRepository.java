package com.halliburton.halliburtonsystem.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.halliburton.halliburtonsystem.entities.Embark;

@Repository
public interface  EmbarkRepository extends JpaRepository<Embark, Long>{
	@Query("SELECT obj FROM Embark obj WHERE obj.begin >= :begin AND obj.end <= :end")
	Page<Embark> find(LocalDate begin, LocalDate end,  Pageable pageable);
	
	@Query("SELECT obj FROM Embark obj")
	Page<Embark> findAll(Pageable pageable);
	
	@Query(nativeQuery=true, value="SELECT * FROM TB_EMBARK WHERE ID = (SELECT MAX(ID) FROM TB_EMBARK WHERE employee_id = :id)")
	Embark findLastEmbark(Long id);
	
}
