package com.ms.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.employeeservice.model.Employee;
import com.ms.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	

	private static final Logger LOGGER 
				= LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		LOGGER.info("Employee add: {}", employee);
		return ResponseEntity
				.ok()
				.body(employeeService.addEmployee(employee));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees() {
		LOGGER.info("Employee findAll");
		return ResponseEntity
				.ok()
				.body(employeeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id) {
		LOGGER.info("Employee findById: {}", id);
		return ResponseEntity
				.ok()
				.body(employeeService.findById(id));
	}
	
	
	@GetMapping("/department/{departmentId}")
	public ResponseEntity<List<Employee>> findByDepartmentId(@PathVariable("departmentId") Long deptId) {
		LOGGER.info("Employee findByDepartmentId: {}", deptId);
		return ResponseEntity
				.ok()
				.body(employeeService.findByDepartmentId(deptId));
	}
	


}
