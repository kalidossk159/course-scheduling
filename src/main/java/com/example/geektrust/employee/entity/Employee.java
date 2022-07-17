package com.example.geektrust.employee.entity;

import com.example.geektrust.constant.Constants;

public class Employee {

  private String name;

  private String email;

  public Employee(String email){
    int atIndex = email.indexOf(Constants.AT);
    name = email.substring(0, atIndex);
    this.email = email;
  }

  public String getName(){
    return name;
  }

  public String getEmail(){
    return email;
  }

}
