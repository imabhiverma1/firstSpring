package com.example.firstSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String projectName;
  private String clientName;

  @ManyToMany(mappedBy = "projects")
  private List<Employee> employees;

  public Project(String projectName, String clientName) {
    this.projectName = projectName;
    this.clientName = clientName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getClientName() {
    return clientName;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }


}
