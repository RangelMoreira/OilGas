package com.halliburton.halliburtonsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halliburton.halliburtonsystem.entities.Employee;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Long>{

}
