package com.ms.departmentservice.model;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}

//it will not have any setter
//only getters
//constructor
