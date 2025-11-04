package com.villidoug.staff.management.controller;

import com.villidoug.staff.management.controller.converter.Converter;
import com.villidoug.staff.management.data.Employment;
import com.villidoug.staff.management.data.Staff;
import com.villidoug.staff.management.domain.Details;
import com.villidoug.staff.management.service.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

  private Service service;
  private Converter converter;

  @Autowired
  public Controller(Service service, Converter converter) {
    this.service = service;
    this.converter = converter;
  }
//  get home
  @GetMapping("/home")
  public String getHome(Model model) {
    return "home";
  }

//Staff get and post
  @GetMapping("/staff")
  public String getStaff(Model model) {
    List<Staff> staff = service.showStaff();
    List<Employment> employments = service.showEmployment();
    model.addAttribute("staff", converter.convertDetails(staff, employments));
    return "staff";
  }
  @PostMapping("/staff")
  public String postStaff(@ModelAttribute Details details, BindingResult result) {
    if (result.hasErrors()) {
      return "staff";
    }
    service.insertStaff(details);
    return "redirect:/staff";
  }
//

}
