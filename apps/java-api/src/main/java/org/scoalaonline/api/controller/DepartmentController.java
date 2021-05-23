package org.scoalaonline.api.controller;

import org.scoalaonline.api.model.Department;
import org.scoalaonline.api.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.scoalaonline.api.exception.*;

import java.util.List;

/**
 * Department controller class, containing GET, POST, PUT and DELETE functions.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

  @Autowired
  DepartmentService departmentService;

  /**
   * Returns all departments from the list.
   * @return a list of departments, along with HttpStatus.OK.
   */
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Department>> getAllDepartments() {
    List<Department> departmentList = departmentService.getAllDepartments();
    return new ResponseEntity<>(departmentList, HttpStatus.OK);
  }

  /**
   * Returns a certain department.
   * @param id which is the department of the entity.
   * @return the department entity or an http error if it doesn't exist.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
    Department department = departmentService.getDepartmentById(id)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "No department found with this ID", new ResourceNotFoundException()
      ));
    return new ResponseEntity<>(department, HttpStatus.OK);
  }


  /**
   * Adds a department entity into the database.
   * @param department which is the entity to be added
   * @return the added department with the Http status created.
   */
  @PostMapping(value = {"","/"})
  public ResponseEntity<Department> addDepartment (@RequestBody Department department) {
    Department savedDepartment = departmentService.addDepartment(department);
    return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
  }

  /**
   * Updates a Department entity from the database.
   * @param id which is the entity's id to be changed
   * @param department which is the updated entity
   * @return the updated Department with the Http status created.
   */

  @PutMapping(value = ("/{id}"))
  public ResponseEntity<Department> updateDepartment (@PathVariable("id") long id,
                                                        @RequestBody Department department) {
    if (departmentService.departmentExists(id)) {
      Department updatedDepartment = departmentService.updateDepartment(id, department);
      return new ResponseEntity<>(updatedDepartment, HttpStatus.ACCEPTED);
    } else {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Cannot update non-existing Department", new ResourceNotFoundException()
      );
    }
  }
}
