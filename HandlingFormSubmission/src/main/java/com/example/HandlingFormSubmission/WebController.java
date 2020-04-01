package com.example.HandlingFormSubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

  @GetMapping("/web")
  public String greetingForm(Model model) {
    model.addAttribute("web", new Web());
    return "web";
  }

  @PostMapping("/web")
  public String greetingSubmit(@ModelAttribute Web web) {
    return "Submit";
  }

}