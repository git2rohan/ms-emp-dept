package com.ms.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.departmentservice.model.Department;

@Repository
public class DepartmentRepository {
	
	
	private List<Department> departments = new ArrayList<>();
	
	//add departments
	public Department addDepartment(Department department) {
		departments.add(department);
		return department;
	}
	
	//find by id
	public Department findById(Long id) {
		return departments.stream()
				.filter(department -> department.getId().equals(id))
				.findFirst()
				.orElseThrow();
	}
	
	//find all
	public List<Department> findAll() {
		return departments;
	}
	
	
	
	

}
