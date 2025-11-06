package com.villidoug.staff.management.service;

import com.villidoug.staff.management.controller.converter.Converter;
import com.villidoug.staff.management.data.Employment;
import com.villidoug.staff.management.data.Staff;
import com.villidoug.staff.management.domain.Details;
import com.villidoug.staff.management.repository.Repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainService {

  private Repository repository;

  @Autowired
  private Converter converter;

  @Autowired
  public MainService(Repository repository) {
    this.repository = repository;
  }

//  show staff or employment service
  public List<Staff> showStaff() {
    return repository.showStaff();
  }

  public List<Employment> showEmployment() {
    return repository.showEmployment();
  }

  public Details searchStaff(String id) {
    Staff staff = repository.getIdStaff(id);
    List<Employment> employments = repository.getIdEmployment(staff.getId());
    Details details = new Details();
    details.setStaff(staff);
    details.setEmployment(employments);
    return details;
  }

//  insert staff and employment
  @Transactional
  public void insertStaff(Details details) {
    repository.insertStaff(details.getStaff());
    Employment employment = new Employment();
    employment.setEmployeeId(details.getStaff().getId());
    employment.setJobTitle(details.getStaff().getPosition());
    employment.setStartDate(String.valueOf(LocalDate.now()));
    repository.insertEmployment(employment);
  }

  @Transactional
  public void updateStaff(Details details) {
    repository.updateStaff(details.getStaff());
    for (Employment employment : details.getEmployment()) {
      repository.updateEmployment(employment);
    }

  }

}
