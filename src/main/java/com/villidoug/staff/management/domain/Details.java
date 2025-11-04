package com.villidoug.staff.management.domain;

import com.villidoug.staff.management.data.Employment;
import com.villidoug.staff.management.data.Staff;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Details {

  private Staff staff;
  private List<Employment> employment;

}
