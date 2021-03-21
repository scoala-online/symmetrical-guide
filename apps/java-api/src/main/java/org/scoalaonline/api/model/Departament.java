package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department")
public class Departament {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "department_id")
  private long id;

  @Column(name = "department_name", nullable = false, length = 20)
  private String departamentName

  public Departament() {
  }

  public long getId() { return id; }

  public String getDepartamentName() { return departamentName; }

  public void setId(long id) { this.id = id; }

  public

}
