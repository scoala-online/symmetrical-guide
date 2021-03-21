package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Corporatist class containing all the basic info.
 */
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

  //region for Constructors.

  /**
   * Constructor for Corporatist.
   */
  public Corporatist() {
  }

  /**
   * Getter function for ID.
   * @return the ID of the corporatist.
   */
  public long getId() {
    return id;
  }

  /**
   * Getter function for the first name.
   * @return the first name of the corporatist.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter function for the middle name.
   * @return the middle name of the corporatist.
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Getter function for the last name.
   * @return the last name of the corporatist.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Getter function for the email.
   * @return the email of the corporatist.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Getter function for the departament.
   * @return the departament of the corporatist.
   */
  public Departament getDepartament() {
    return departament;
  }

  //region for Setters


  /**
   * Setter function for the ID.
   * @param id which is the id for the corporatist.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Setter function for the first name.
   * @param firstName which is the first name of the Corporatist class.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Setter function for the middle name.
   * @param middleName which is the middle name of the Corporatist class.
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  /**
   * Setter function for the last name.
   * @param lastName which is the last name of the Corporatist class.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Setter function for the email.
   * @param email which is the email of the Corporatist class.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Setter function for the Department object.
   * @param departament which is the department onject for the Corporatist class.
   */
  public void setDepartament(Departament departament) {
    this.departament = departament;
  }

  /**
   * Equals function for the object.
   * @param o TODO: DEFINE HERE
   * @return whether the object is the corporatist class or not.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Corporatist corporatist = (Corporatist) o;
    return id == corporatist.id &&
      departament == corporatist.departament &&
      firstName.equals(corporatist.firstName) &&
      middleName.equals(corporatist.middleName) &&
      lastName.equals(corporatist.lastName) &&
      email.equals(corporatist.email);
  }

  /**
   * TODO: COMMENT HERE
   * @return TODO: COMMENT HERE
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, middleName, lastName, email, departament);
  }
}
