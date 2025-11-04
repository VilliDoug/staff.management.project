package com.villidoug.staff.management.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Employment {

  private String id;
  private String employeeId;
  private String jobTitle;
  private String department;
  private String startDate;
  private String terminationDate;
  private String contractType;

}
