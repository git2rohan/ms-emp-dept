package com.ms.departmentservice.controller;

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

import com.ms.departmentservice.client.EmployeeClient;
import com.ms.departmentservice.model.Department;
import com.ms.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private static final Logger LOGGER 
				= LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		return ResponseEntity
				.ok()
				.body(departmentService.addDepartment(department));
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> findAllDepartments() {
		LOGGER.info("Department findAll");
		return ResponseEntity
				.ok()
				.body(departmentService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> findById(@PathVariable Long id) {
		LOGGER.info("Department findById: {}", id);
		return ResponseEntity
				.ok()
				.body(departmentService.findById(id));
	}
	
	@GetMapping("/with-employees")
	public ResponseEntity<List<Department>> findWithEmployees() {
		LOGGER.info("Department findWithEmployees");
		
		List<Department> list = departmentService.findAll();
		list.forEach(department 
			-> department.setEmployees(employeeClient.findByDepartmentId(department.getId()).getBody()));
		
		return ResponseEntity.ok().body(list);
	}
}
