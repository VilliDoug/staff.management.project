package com.villidoug.staff.management.controller.converter;

import com.villidoug.staff.management.data.Employment;
import com.villidoug.staff.management.data.Staff;
import com.villidoug.staff.management.domain.Details;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class Converter {

  public List<Details> convertDetails (List<Staff> staffList, List<Employment> employmentList) {
//    NPE checkers for both lists - new syntax
    List<Staff> safeStaffList = Optional.ofNullable(staffList).orElse(Collections.emptyList());
    List<Employment> safeEmploymentList = Optional.ofNullable(employmentList).orElse(Collections.emptyList());
//    initialize the result list (return)
    List<Details> detailsList = new ArrayList<>();
// add each checked staff to the safeStaffList
    safeStaffList.forEach(staff -> {
      Details details = new Details();
      details.setStaff(staff);
// create and populate the matching list by finding matching employment records
      List<Employment> matchEmployment = safeEmploymentList.stream()
          .filter(employment -> Objects.equals(staff.getId(), employment.getEmployeeId()))
          .toList();
      details.setEmployment(matchEmployment);
      detailsList.add(details);
    });
    return detailsList;
  }

}
