package org.scoalaonline.api.controller;

import org.scoalaonline.api.model.Corporatist;
import org.scoalaonline.api.service.CorporatistService;
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
@RequestMapping("/corporatist")
public class CorporatistController {

  @Autowired
  CorporatistService corporatistService;

  //region getter mappings
  /**
   *
   * @return
   */
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Corporatist>> getAllCorporatists() {
    List<Corporatist> corporatistList = corporatistService.getAllCorporatists();
    return new ResponseEntity<>(corporatistList, HttpStatus.OK);
  }

  /**
   *
   * @param id
   * @return
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Corporatist> getCorporatistById(@PathVariable("id") long id) {
    Corporatist corporatist = corporatistService.getCorporatistByID(id)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "No corporatist founds with this ID", new ResourceNotFoundException()
      ));
    return new ResponseEntity<>(corporatist, HttpStatus.OK);
  }

  //endregion
}
