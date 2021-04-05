package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Supervisor class containing all the basic info.
 */
@Entity
@Table(name = "supervisor")
public class Supervisor {

  //region fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "supervisor_id")
  private long id;

  @Column(name = "first_name", nullable = false, length = 20)
  private String firstName;

  @Column(name ="middle_name", length = 20)
  private String middleName;

  @Column(name = "last_name", nullable = false, length = 20)
  private String lastName;

  @Column(name = "email", nullable = false, length = 200)
  private String email;

  @OneToOne
  private Department department;

  //region for Constructors.

  /**
   * Constructor for Supervisor.
   */
  public Supervisor() {
  }

  /**
   * Getter function for ID.
   * @return the ID of the Supervisor.
   */
  public long getId() {
    return id;
  }

  /**
   * Getter function for the first name.
   * @return the first name of the Supervisor.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter function for the middle name.
   * @return the middle name of the Supervisor.
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Getter function for the last name.
   * @return the last name of the Supervisor.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Getter function for the email.
   * @return the email of the Supervisor.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Getter function for the departament.
   * @return the departament of the Supervisor.
   */
  public Department getDepartament() {
    return department;
  }

  //region for Setters
  /**
   * Setter function for the ID.
   * @param id which is the id for the Supervisor.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Setter function for the first name.
   * @param firstName which is the first name of the Supervisor class.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Setter function for the middle name.
   * @param middleName which is the middle name of the Supervisor class.
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  /**
   * Setter function for the last name.
   * @param lastName which is the last name of the Supervisor class.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Setter function for the email.
   * @param email which is the email of the Supervisor class.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Setter function for the Department object.
   * @param department which is the department onject for the Supervisor class.
   */
  public void setDepartament(Department department) {
    this.department = department;
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
    Supervisor supervisor = (Supervisor) o;
    return id == supervisor.id &&
      department == supervisor.department &&
      firstName.equals(supervisor.firstName) &&
      middleName.equals(supervisor.middleName) &&
      lastName.equals(supervisor.lastName) &&
      email.equals(supervisor.email);
  }

  /**
   * TODO: COMMENT HERE
   * @return TODO: COMMENT HERE
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, middleName, lastName, email, department);
  }
}
