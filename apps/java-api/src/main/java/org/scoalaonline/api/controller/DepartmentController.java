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
 * TODO: ADD DESCRIPTION HERE
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

  @Autowired
  DepartmentService departmentService;

  //region getter mappings
  /**
   * TODO: COMMENT HERE
   * @return
   */
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Department>> getAllDepartments() {
    List<Department> departmentList = departmentService.getAllDepartments();
    return new ResponseEntity<>(departmentList, HttpStatus.OK);
  }

  /**
   * TODO: COMMENT HERE
   * @param id
   * @return
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
    Department department = departmentService.getDepartmentById(id)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "No department founds with this ID", new ResourceNotFoundException()
      ));
    return new ResponseEntity<>(department, HttpStatus.OK);
  }

  //endregion
}
