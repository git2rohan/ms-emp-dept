package com.ms.employeeservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.employeeservice.model.Employee;

@Repository
public class EmployeeRepository {
	
private List<Employee> employees = new ArrayList<>();
	
	//add Employees
	public Employee addEmployee(Employee Employee) {
		employees.add(Employee);
		return Employee;
	}
	
	//find by id
	public Employee findById(Long id) {
		return employees.stream()
				.filter(emp -> emp.id().equals(id))
				.findFirst()
				.orElseThrow();
	}
	
	//find all
	public List<Employee> findAll() {
		return employees;
	}
	
	//find by dept id
	public List<Employee> findByDepartmentId(Long deptId) {
		return employees.stream()
				.filter(emp -> emp.departmentId().equals(deptId))
				.toList();
	}

}
