package org.scoalaonline.api.controller;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.scoalaonline.api.model.Supervisor;
import org.scoalaonline.api.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.scoalaonline.api.exception.*;

import java.util.List;

/**
 * Supervisor controller class, containing GET, POST, PUT and DELETE functions.
 */
@RestController
@RequestMapping("/supervisors")
public class SupervisorController {

  @Autowired
  SupervisorService supervisorService;

  /**
   * Returns all supervisors from the list.
   * @return a list of supervisors, along with HttpStatus.OK.
   */
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Supervisor>> getAllSupervisors() {
    List<Supervisor> supervisorList = supervisorService.getAllSupervisors();
    return new ResponseEntity<>(supervisorList, HttpStatus.OK);
  }

  /**
   * Returns a certain supervisor.
   * @param id which is the id of the entity.
   * @return the supervisor entity or an http error if it doesn't exist.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Supervisor> getSupervisorById(@PathVariable("id") long id) {
    Supervisor supervisor = supervisorService.getSupervisorByID(id)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "No supervisor found with this ID", new ResourceNotFoundException()
      ));
    return new ResponseEntity<>(supervisor, HttpStatus.OK);
  }

  /**
   * Adds a Supervisor entity into the database.
   * @param supervisor which is the entity to be added
   * @return the added supervisor with the Http status created.
   */
  @PostMapping(value = {"","/"})
  public ResponseEntity<Supervisor> addSupervisor (@RequestBody Supervisor supervisor) {
    Supervisor savedSupervisor = supervisorService.addSupervisor(supervisor);
    return new ResponseEntity<>(savedSupervisor, HttpStatus.CREATED);
  }


  /**
   * Updates a Supervisor entity from the database.
   * @param id which is the entity's id to be changed
   * @param supervisor which is the updated entity
   * @return the updated Supervisor with the Http status created.
   */
  @PutMapping(value = ("/{id}"))
  public ResponseEntity<Supervisor> updateSupervisor (@PathVariable("id") long id,
                                                      @RequestBody Supervisor supervisor) {
    if (supervisorService.supervisorExists(id)) {
      Supervisor updatedSupervisor = supervisorService.updateSupervisor(id, supervisor);
      return new ResponseEntity<>(updatedSupervisor, HttpStatus.ACCEPTED);
    } else {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Cannot update non-existing Supervisor", new ResourceNotFoundException()
      );
    }
  }

  /**
   * Deletes a Supervisor entity from the database.
   * @param id which is the entity's id to be deleted
   * @return the deleted Supervisor with the Http status created.
   */
  @DeleteMapping(value = ("/{id}"))
  public ResponseEntity<HttpStatus> deleteSupervisor (@PathVariable("id") long id) {
    if (supervisorService.supervisorExists(id)) {
      supervisorService.deleteSupervisor(id);
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
    } else {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Cannot delete non-existing Supervisor", new ResourceNotFoundException()
      );
    }
  }

}
