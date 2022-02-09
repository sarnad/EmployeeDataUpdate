package com.cg.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.model.Employee;
import com.cg.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public void addEmployeeRecords(List<Employee> employeeList) {
		repository.saveAllAndFlush(employeeList);
	}

}