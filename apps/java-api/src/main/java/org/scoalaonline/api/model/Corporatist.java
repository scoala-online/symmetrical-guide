package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "corporatist")
public class Corporatist {

  //region fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "corporatist_id")
  private long id;

  @Column(name = "first_name", nullable = false, length = 20)
  private String firstName;

  @Column(name ="middle_name", length = 20)
  private String middleName;

  @Column(name = "last_name", nullable = false, length = 20)
  private String lastName;

  @Column(name = "email", nullable = false, length = 200)
  private String email;

  @ManyToOne
  private Departament departament;

  public Corporatist() {
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public Departament getDepartament() {
    return departament;
  }

}
