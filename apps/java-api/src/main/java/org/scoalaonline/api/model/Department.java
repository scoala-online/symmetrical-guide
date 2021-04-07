package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "department_id")
  private long id;

  @Column(name = "department_name", nullable = false, length = 20)
  private String departmentName;

  @OneToOne (cascade = CascadeType.ALL)
  @JoinColumn (name = "supervisor_id", referencedColumnName = "department_id")
  private Supervisor supervisor;

  /**
   * Constructor for department
   */
  public Department() {

  }

  /**
   * Getter for id of the department
   * @return id of the department
   */
  public long getId() {
    return id;
  }

  /**
   * Getter for the name of the department
   * @return the name of the department
   */
  public String getDepartmentName() {
    return departmentName;
  }

  /**
   * Getter for the supervisor of the department.
   * @return the supervisor.
   */
  public Supervisor getSupervisor() {
    return supervisor;
  }

  /**
   * Setter for id of the department
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Setter for the name of the department
   */
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  /**
   * Setter function for the supervisor of the department.
   * @param supervisor which is the supervisor to be added.
   */
  public void setSupervisor(Supervisor supervisor) {
    this.supervisor = supervisor;
  }

  /**
   * Equals function used to compare two departments
   * @param o department to be compared
   * @return whether they are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Department department = (Department) o;
    return id == department.id &&
      supervisor == department.supervisor &&
      departmentName.equals(department.departmentName);
  }

  /**
   * HashMaps the id and department details.
   * @return a HashMap.
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, departmentName, supervisor);
  }
}
