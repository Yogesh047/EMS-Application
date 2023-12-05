package com.wishfy.EMS.repository;


import com.wishfy.EMS.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByDepartment(String department);
    List<Employee> findAllByOrderByJoiningDateDesc();

}

