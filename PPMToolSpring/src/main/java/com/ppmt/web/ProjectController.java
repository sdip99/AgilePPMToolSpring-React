package com.ppmt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppmt.domain.Project;
import com.ppmt.services.MapValidationService;
import com.ppmt.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectSer;
	
	@Autowired
	private MapValidationService mapValidation;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bResult) {
		ResponseEntity<?> errorMap = mapValidation.MapValidationServic(bResult);
		if(errorMap!=null) return errorMap;
		Project pro = projectSer.saveOrUpdaProject(project);
		return new ResponseEntity<Project>(pro, HttpStatus.CREATED);
	}
	
	@GetMapping("/{proId}")
	public ResponseEntity<?>  getProjectbyId(@PathVariable String proId){
		Project project = projectSer.findByProjectIdentifier(proId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> findAllProjects(){
		return new ResponseEntity<Iterable<Project>>(projectSer.findAllProjects(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{proId}")
	public ResponseEntity<?>  deleteProjectbyId(@PathVariable String proId){
		projectSer.deleteProjectByID(proId);
		return new ResponseEntity<String>("Project with id '" + proId + "' deleted successfully", HttpStatus.OK);
		}
}
