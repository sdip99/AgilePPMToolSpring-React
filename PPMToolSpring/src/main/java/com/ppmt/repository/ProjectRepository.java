package com.ppmt.repository;

import 
org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ppmt.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	
		
}
