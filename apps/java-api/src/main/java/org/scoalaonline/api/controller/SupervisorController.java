package org.scoalaonline.api.controller;

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
 * Supervisor controller class, containing GET functions.
 */
@RestController
@RequestMapping("/supervisors")
public class SupervisorController {

  @Autowired
  SupervisorService supervisorService;

  //region getter mappings
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

  //endregion
}
