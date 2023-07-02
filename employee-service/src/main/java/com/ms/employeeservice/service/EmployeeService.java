package com.ms.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.employeeservice.model.Employee;
import com.ms.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee emp) {
		return employeeRepository.addEmployee(emp);
	}
	
	
	public Employee findById(Long id) {
		return employeeRepository.findById(id);
	}
	
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public List<Employee> findByDepartmentId(Long deptId) {
		return employeeRepository.findByDepartmentId(deptId);
	}

}
