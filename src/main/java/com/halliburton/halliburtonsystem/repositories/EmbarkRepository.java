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
}
