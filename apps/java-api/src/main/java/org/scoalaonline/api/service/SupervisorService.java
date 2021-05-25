package org.scoalaonline.api.service;

import org.scoalaonline.api.model.Supervisor;
import org.scoalaonline.api.repo.SupervisorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Supervisor class containing all the service methods
 */
@Service
public class SupervisorService {

  @Autowired
  SupervisorRepo supervisorRepo;

  /**
   * Gets all the supervisors of the database.
   * @return a list of supervisors.
   */
  public List<Supervisor> getAllSupervisors() {
    return supervisorRepo.findAll();
  }

  /**
   * Finds the supervisor by ID.
   * @param id - the id of the supervisor to be found.
   * @return either the supervisor or a null object.
   */
  public Optional<Supervisor> getSupervisorByID (long id) {
    return supervisorRepo.findById(id);
  }

  /**
   * Adds a new supervisor into the database.
   * @param supervisor which is the supervisor to be added.
   * @return the repo with the supervisor added.
   */
  public Supervisor addSupervisor (Supervisor supervisor) {
    Supervisor supervisorToAdd = new Supervisor();

    supervisorToAdd.setFirstName(supervisor.getFirstName());
    supervisorToAdd.setMiddleName(supervisor.getMiddleName());
    supervisorToAdd.setLastName(supervisor.getLastName());
    supervisorToAdd.setEmail(supervisor.getEmail());
    supervisorToAdd.setDepartment(supervisor.getDepartment());
    return supervisorRepo.save(supervisorToAdd);
  }

  /**
   * Updates a supervisor entity in the database.
   * @param id which is the id of the supervisor to be changed.
   * @param supervisor which is the updated supervisor.
   * @return the repo with the updated supervisor.
   */
  public Supervisor updateSupervisor (long id, Supervisor supervisor) {
    try{
      Supervisor supervisorToUpdate = supervisorRepo.findById(id).get();
      if (supervisor.getFirstName() != null) {
        supervisorToUpdate.setFirstName(supervisor.getFirstName());
      }
        supervisorToUpdate.setFirstName(supervisor.getFirstName());
      if (supervisor.getLastName() != null) {
        supervisorToUpdate.setFirstName(supervisor.getLastName());
      }
      if (supervisor.getEmail() != null) {
        supervisorToUpdate.setEmail(supervisor.getEmail());
      }
      if (supervisor.getDepartment() != null) {
        supervisorToUpdate.setDepartment(supervisor.getDepartment());
      }
      return supervisorRepo.save(supervisorToUpdate);
    } catch (NoSuchElementException e) {
      System.out.println("The supervisor to update doesn't exist.");
      return null;
    }
  }

  /**
   * Deletes a supervisor.
   * @param id which is the id of the supervisor to be deleted.
   */
  public void deleteSupervisor (long id) {
    supervisorRepo.deleteById(id);
  }

  /**
   * Checks whether a given supervisor exists in the database.
   * @param id which is the id of the supervisor to be searched
   * @return true if the supervisor exists, false otherwise.
   */
  public boolean supervisorExists (long id) {
     return supervisorRepo.existsById(id);
  }

}
