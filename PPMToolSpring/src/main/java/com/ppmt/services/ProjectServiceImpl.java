package com.ppmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.stereotype.Service;

import com.ppmt.domain.Project;
import com.ppmt.exceptions.ProjectIDException;
import com.ppmt.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public Project saveOrUpdaProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepo.save(project);
		} catch (Exception e) {
			throw new ProjectIDException("Project ID :" + project.getProjectIdentifier().toUpperCase());
		}
	}

	@Override
	public Project findByProjectIdentifier(String projectIdentifier) {
		Project project = projectRepo.findByProjectIdentifier(projectIdentifier.toUpperCase());
		if (project == null) {
			throw new ProjectIDException("Project ID: '" + projectIdentifier.toUpperCase() + "' does not exist");
		}
		return project;
	}

	@Override
	public Iterable<Project> findAllProjects() {
		return projectRepo.findAll();
	}

	@Override
	public void deleteProjectByID(String projectIdentifier) {
		Project project = projectRepo.findByProjectIdentifier(projectIdentifier.toUpperCase());
		if (project == null) {
			throw new ProjectIDException("Project ID: '" + projectIdentifier.toUpperCase() + "' does not exist");
		}
		projectRepo.delete(project);
	}

}
