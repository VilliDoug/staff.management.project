package com.villidoug.staff.management.repository;

import com.villidoug.staff.management.data.Employment;
import com.villidoug.staff.management.data.Staff;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Repository {

//  Show staff or employment tables
  @Select("SELECT * FROM staff")
  List<Staff> showStaff();

  @Select("SELECT * FROM staff WHERE id = #{id}")
  Staff getIdStaff(String id);

  @Select("SELECT * FROM employment")
  List<Employment> showEmployment();

  @Select("SELECT * FROM employment WHERE employee_id = #{employeeId}")
  List<Employment> getIdEmployment(String employeeId);

//  insert data into staff or employment
  @Insert("INSERT INTO staff (name, gender, age, email, residence, position, active)"
      + " VALUES (#{name}, #{gender}, #{age}, #{email}, #{residence}, #{position}, true)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertStaff(Staff staff);

  @Insert("INSERT INTO employment (employee_id, job_title, department, start_date, termination_date, contract_type)"
      + " VALUES (#{employeeId}, #{jobTitle}, #{department}, #{startDate}, #{terminationDate}, #{contractType})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertEmployment(Employment employment);

//  update
  @Update("UPDATE staff SET name = #{name}, gender = #{gender}, age = #{age}, email = #{email},"
      + " residence = #{residence}, position = #{position}, active = #{active}"
      + " WHERE id = #{id}")
  void updateStaff(Staff staff);

  @Update("UPDATE employment SET job_title = #{jobTitle}, department = #{department},"
      + " termination_date = #{terminationDate}, contract_type = #{contractType}"
      + " WHERE id = #{id}")
  void updateEmployment(Employment employment);

}
