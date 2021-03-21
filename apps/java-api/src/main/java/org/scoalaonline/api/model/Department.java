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

  public Departament() {
  }

  public long getId() { return id; }

  public String getDepartmentName() { return departmentName; }

  public void setId(long id) { this.id = id; }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Department department = (Department) o;
    return id == department.id &&
      Objects.equals(departmentName, department.departmentName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, departmentName);
  }
}
