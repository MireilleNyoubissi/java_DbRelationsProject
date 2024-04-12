package com.dbRelation.db_relationProject.manytomany.controller;

import com.dbRelation.db_relationProject.manytomany.dto.ProjectDto;
import com.dbRelation.db_relationProject.manytomany.entities.Project;
import com.dbRelation.db_relationProject.manytomany.repository.EmployeeRepository;
import com.dbRelation.db_relationProject.manytomany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectName(project.getProjectName());
        return new ResponseEntity<>(projectRepository.save(project), HttpStatus.CREATED);

    }


}
