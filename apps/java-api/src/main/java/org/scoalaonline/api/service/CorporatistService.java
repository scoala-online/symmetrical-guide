package org.scoalaonline.api.service;


import org.scoalaonline.api.model.Corporatist;
import org.scoalaonline.api.repo.CorporatistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Corporatist class which contains all the service methods.
 */
@Service
public class CorporatistService {

  @Autowired
  CorporatistRepo corporatistRepo;

  /**
   * Finds all the corporatist entities from the repo.
   * @return the list of the corporatist entities.
   */
  public List<Corporatist> getAllCorporatists() {
    return corporatistRepo.findAll();
  }

  /**
   * Returns a corporatist entity.
   * @param id which is the id of the entity to be searched.
   * @return the searched entity.
   */
  public Optional<Corporatist> getCorporatistByID (long id) {
    return corporatistRepo.findById(id);
  }

  /***
   * Adds a corporatist entity into the database.
   * @param corporatist which is the entity to be added.
   * @return the repo with the entity added.
   */
  public Corporatist addCorporatist (Corporatist corporatist) {
    Corporatist corporatistToAdd = new Corporatist();
    corporatistToAdd.setFirstName(corporatist.getFirstName());
    corporatistToAdd.setMiddleName(corporatist.getMiddleName());
    corporatistToAdd.setLastName(corporatist.getLastName());
    corporatistToAdd.setEmail(corporatist.getEmail());
    corporatistToAdd.setDepartament(corporatist.getDepartament());

    return corporatistRepo.save(corporatistToAdd);
  }

  /**
   * Updates a corporatist entity.
   * @param id which is the id of the corporatist to be changed.
   * @param corporatist which is the new entity to be put into the repo.
   * @return the repo with the changed entity.
   */
  public Corporatist updateCorporatist (long id, Corporatist corporatist) {
    Corporatist corporatistToUpdate = corporatistRepo.findById(id).get();
    if (corporatist.getFirstName() != null) {
      corporatistToUpdate.setFirstName(corporatist.getFirstName());
    }
    if (corporatist.getMiddleName() != null) {
      corporatistToUpdate.setMiddleName(corporatist.getMiddleName());
    }
    if (corporatist.getLastName() != null) {
      corporatistToUpdate.setLastName(corporatist.getLastName());
    }
    if (corporatist.getEmail() != null) {
      corporatistToUpdate.setEmail(corporatist.getEmail());
    }
    if (corporatist.getDepartament() != null) {
      corporatistToUpdate.setDepartament(corporatist.getDepartament());
    }
    return corporatistRepo.save(corporatistToUpdate);
  }

  /**
   * Deletes a corporatist entity.
   * @param id which is the id of the corporatist entity to be deleted.
   */
  public void deleteCorporatist (long id) {
    corporatistRepo.deleteById(id);
  }

  /**
   * checks whether the corporatist entity exists.
   * @param id which is the id of the entity.
   * @return whether the entity exists.
   */
  public boolean corporatistExists (long id) {
    return corporatistRepo.existsById(id);
  }
}
