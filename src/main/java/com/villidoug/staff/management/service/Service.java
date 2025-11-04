package com.villidoug.staff.management.service;

import com.villidoug.staff.management.controller.converter.Converter;
import com.villidoug.staff.management.data.Employment;
import com.villidoug.staff.management.data.Staff;
import com.villidoug.staff.management.domain.Details;
import com.villidoug.staff.management.repository.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

  private Repository repository;

  @Autowired
  private Converter converter;

  @Autowired
  public Service(Repository repository) {
    this.repository = repository;
  }
//  show staff or employment service
  public List<Staff> showStaff() {
    return repository.showStaff();
  }

  public List<Employment> showEmployment() {
    return repository.showEmployment();
  }
// insert staff and employment service
  public void insertStaff(Details details) {
    repository.insertStaff(details.getStaff());
    for (Employment employment : details.getEmployment()) {
      employment.setEmployeeId(details.getStaff().getId());
      employment.setStartDate(String.valueOf(LocalDate.now()));
      repository.insertEmployment(employment);

    }
  }
//  make an insert method for the employment table only
  public void insertEmployment(Details details) {
    }
  }
//  fetch one staff member through ID
//  public Details fetchStaff(String id) {
//    ListStaff staff = repository.fetchStaff(id);
//    List<Employment> employments = List.of();
//    employments = employments.stream()
//        .filter(employment -> Objects.equals(staff.getId(), employment.getEmployeeId()))
//        .toList();
//    return converter.convertDetails(staff, employments);
  }


