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
 * TODO: ADD DESCRIPTION HERE
 */
@RestController
@RequestMapping("/department")
public class SupervisorController {

  @Autowired
  SupervisorService supervisorService;

  //region getter mappings
  /**
   * TODO: COMMENT HERE
   * @return
   */
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Supervisor>> getAllSupervisors() {
    List<Supervisor> supervisorList = supervisorService.getAllSupervisors();
    return new ResponseEntity<>(supervisorList, HttpStatus.OK);
  }

  /**
   * TODO: COMMENT HERE
   * @param id
   * @return
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Supervisor> getCorporatistById(@PathVariable("id") long id) {
    Supervisor supervisor = supervisorService.getSupervisorByID(id)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "No department founds with this ID", new ResourceNotFoundException()
      ));
    return new ResponseEntity<>(supervisor, HttpStatus.OK);
  }

  //endregion
}
