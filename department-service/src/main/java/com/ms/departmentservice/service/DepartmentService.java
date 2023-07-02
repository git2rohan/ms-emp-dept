package com.ms.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.departmentservice.model.Department;
import com.ms.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//add departments
		public Department addDepartment(Department department) {
			return departmentRepository.addDepartment(department);
		}
		
		//find by id
		public Department findById(Long id) {
			return departmentRepository.findById(id);
		}
		
		//find all
		public List<Department> findAll() {
			return departmentRepository.findAll();
		}

}
