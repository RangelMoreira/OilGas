package com.halliburton.halliburtonsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halliburton.halliburtonsystem.entities.Embark;

@Repository
public interface  EmbarkRepository extends JpaRepository<Embark, Long>{

}
