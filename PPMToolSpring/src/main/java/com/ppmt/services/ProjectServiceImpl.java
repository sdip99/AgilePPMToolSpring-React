package com.ppmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppmt.domain.Project;
import com.ppmt.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public Project saveOrUpdaProject(Project project) {
		
		return projectRepo.save(project);
	}
}
