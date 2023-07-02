package com.ms.departmentservice.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.ms.departmentservice.model.Employee;

@HttpExchange
public interface EmployeeClient {
	
	@GetExchange("/employee/department/{departmentId}")
	public ResponseEntity<List<Employee>> findByDepartmentId(@PathVariable("departmentId") Long deptId);
	
	
	

}
