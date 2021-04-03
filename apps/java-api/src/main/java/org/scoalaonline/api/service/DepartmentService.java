package org.scoalaonline.api.service;

import org.scoalaonline.api.model.Department;
import org.scoalaonline.api.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DepartmentService {
  @Autowired
  DepartmentRepo departmentRepo;

  public List<Department> getAllDepartments () { return departmentRepo.findAll(); }

  public Optional<Department> getDepartmentById (long id ) { return departmentRepo.findById( id ); }

  public Department addDepartment ( Department department ) {

  }
}
