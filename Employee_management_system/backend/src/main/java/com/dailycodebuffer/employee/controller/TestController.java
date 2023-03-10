package com.dailycodebuffer.employee.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
	  System.out.println("\n All access ");
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('user') or hasRole('moderator') or hasRole('admin')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/moderator")
  @PreAuthorize("hasRole('moderator')")
  public String moderatorAccess() {
	  System.out.println("\nModerator role*********");
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('admin')")
  public String adminAccess() {
	  System.out.println("\nAdmin access");
    return "Admin Board.";
  }
}