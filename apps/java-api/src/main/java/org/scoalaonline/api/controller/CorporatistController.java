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
 * Controller controller class, containing GET functions.
 */
@RestController
@RequestMapping("/corporatists")
public class CorporatistController {

  @Autowired
  CorporatistService corporatistService;

  //region getter mappings
  /**
   * Returns all corporatists from the list.
   * @return a list of corporatists, along with HttpStatus.OK.
   */
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Corporatist>> getAllCorporatists() {
    List<Corporatist> corporatistList = corporatistService.getAllCorporatists();
    return new ResponseEntity<>(corporatistList, HttpStatus.OK);
  }

  /**
   * Returns a certain corporatist.
   * @param id which is the id of the entity.
   * @return the corporatist entity or an http error if it doesn't exist.
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
