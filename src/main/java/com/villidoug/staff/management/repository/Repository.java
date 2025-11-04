package com.villidoug.staff.management.repository;

import com.villidoug.staff.management.data.Employment;
import com.villidoug.staff.management.data.Staff;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Repository {

//  Show staff or employment tables
  @Select("SELECT * FROM staff")
  List<Staff> showStaff();

  @Select("SELECT * FROM employment")
  List<Employment> showEmployment();

//  insert data into staff or employment
  @Insert("INSERT INTO staff (name, gender, age, email, residence, position, active)"
      + " VALUES (#{name}, #{gender}, #{age}, #{email}, #{residence}, #{position}, true)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertStaff(Staff staff);

  @Insert("INSERT INTO employment (employee_id, job_title, department, start_date, termination_date, contract_type)"
      + " VALUES (#{employeeId}, #{jobTitle}, #{department}, #{startDate}, #{terminationDate}, #{contractType})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertEmployment(Employment employment);

//  fetch staff by id
  @Select("SELECT * FROM staff WHERE id = #{id}")
  Staff fetchStaff(String id);

}
