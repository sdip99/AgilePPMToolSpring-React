package com.ppmt.services;

import org.springframework.jca.cci.core.InteractionCallback;

import com.ppmt.domain.Project;

public interface ProjectService {

	public Project saveOrUpdaProject(Project project);
	public Project findByProjectIdentifier(String projectIdentifier);
	public Iterable<Project> findAllProjects();
	public void deleteProjectByID(String projectIdentifier);
}
