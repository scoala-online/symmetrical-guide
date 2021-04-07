package org.scoalaonline.api.service;

import org.scoalaonline.api.model.Department;
import org.scoalaonline.api.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DepartmentService {
  @Autowired
  DepartmentRepo departmentRepo;

  /**
   * Getter for all departments
   * @return all department entities
   */
  public List<Department> getAllDepartments () { return departmentRepo.findAll(); }

  /**
   * Getter for departments by id
   * @param id the id of the selected department
   * @return the department selected
   */
  public Optional<Department> getDepartmentById ( long id ) { return departmentRepo.findById( id ); }

  /**
   * Deletes a department
   * @param id the id of the department to be deleted
   */
  public void deleteDepartment ( long id ) { departmentRepo.deleteById( id ); }

  /**
   * Adds a department entity
   * @param department the department to be added
   * @return the new configuration with the department added
   */
  public Department addDepartment ( Department department ) {
    Department departmentToAdd = new Department();
    departmentToAdd.setName( department.getName() );
    departmentToAdd.setId( department.getId() );
    departmentToAdd.setSupervisor( department.getSupervisor() );

    return departmentRepo.save( departmentToAdd );
  }

  /**
   * Updates a department
   * @param id the id of the department to be changed
   * @param department the configuration of the new department
   * @return the configuration with the department changed
   */
  public Department updateDepartment (long id, Department department ) {
    try {
      Department departmentToUpdate = departmentRepo.findById(id).get();
      if (department.getName() != null) {
        departmentToUpdate.setName(department.getName());
      }

      if (department.getSupervisor() != null) {
        departmentToUpdate.setSupervisor(department.getSupervisor());
      }
      return departmentRepo.save(departmentToUpdate);
    } catch (NoSuchElementException e) {
      System.out.println("The department to update doesn't exist");
      return null;
    }
  }

  /**
   * Checks if a department exists
   * @param id the id of the department to be checked
   * @return if the department exists
   */
  public boolean departmentExists( long id ) { return departmentRepo.existsById( id ); }
}
