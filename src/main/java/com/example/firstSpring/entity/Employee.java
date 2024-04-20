package com.example.firstSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int employeeId;
  String employeeName;
  String employeeCity;
  @OneToOne
  @JoinColumn(name = "fk_spouse")
  private Spouse spouse;
  @OneToMany
  private List<Address> addresses;
  @ManyToMany
  @JoinTable(name = "employee_project",
      joinColumns = @JoinColumn(name = "fk_employee"),
      inverseJoinColumns = @JoinColumn(name = "fk_project"))
  private List<Project> projects;

  public Employee() {
  }

  public Employee(int employeeId, String employeeName, String employeeCity) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.employeeCity = employeeCity;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  public Spouse getSpouse() {
    return spouse;
  }

  public void setSpouse(Spouse spouse) {
    this.spouse = spouse;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeeCity() {
    return employeeCity;
  }

  public void setEmployeeCity(String employeeCity) {
    this.employeeCity = employeeCity;
  }

  public void removeProject(Project project) {
    this.projects.remove(project);
    project.getEmployees().remove(project);
  }

  private void addProject(Project project) {
    this.projects.add(project);
    project.getEmployees().add(this);
  }
}
