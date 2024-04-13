package com.dbRelation.db_relationProject.manytomany.controller;

import com.dbRelation.db_relationProject.manytomany.dto.AddEmployeeToProjectDto;
import com.dbRelation.db_relationProject.manytomany.dto.ProjectDto;
import com.dbRelation.db_relationProject.manytomany.entities.Employee;
import com.dbRelation.db_relationProject.manytomany.entities.Project;
import com.dbRelation.db_relationProject.manytomany.repository.EmployeeRepository;
import com.dbRelation.db_relationProject.manytomany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        project.setProjectName(projectDto.getProjectName());
        return new ResponseEntity<>(projectRepository.save(project), HttpStatus.CREATED);

    }

    @PostMapping("{idProject}/employees")
    public ResponseEntity<?> addEmployeeInAProject(@PathVariable Long idProject, @RequestBody AddEmployeeToProjectDto addEmployeeToProjectDto){
        Optional<Project> optionalProject = projectRepository.findById(idProject);
        if(optionalProject.isPresent()) {
            Project project = optionalProject.get();

            if(addEmployeeToProjectDto.getEmployeeId() != null) {
                Optional<Employee> optionalEmployee = employeeRepository.findById(addEmployeeToProjectDto.getEmployeeId());
                if(optionalEmployee.isPresent()) {
                    Employee employee = optionalEmployee.get();
                    Set<Employee> employeeSet = new HashSet<>();
                    employeeSet.add(employee);

                    project.setEmployees(employeeSet);

                    return new ResponseEntity<>(projectRepository.save(project), HttpStatus.CREATED);
                }
            }
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Project not found", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{idProject}")
    public ResponseEntity<?> getProjectById(@PathVariable Long idProject) {
        Optional<Project> optionalProject = projectRepository.findById(idProject);
        if(optionalProject.isPresent()) {
            return new ResponseEntity<>(optionalProject.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Project not found", HttpStatus.NOT_FOUND);
    }


}
