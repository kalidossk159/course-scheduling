package com.example.geektrust.registration.entity;

import com.example.geektrust.constant.Constants;
import com.example.geektrust.course.entity.Course;
import com.example.geektrust.employee.entity.Employee;
import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.IdGenerationKey;
import com.example.geektrust.id.StringIdGenerator;
import com.example.geektrust.registration.enums.RegistrationStatus;
import java.util.HashMap;
import java.util.Map;

public class Registration extends Entity<String> {

  private Employee employee;

  private Course course;

  private RegistrationStatus registrationStatus;

  public Registration(){
    super(EntityType.REGISTRATION, new StringIdGenerator());
  }

  public Registration(Employee employee, Course course){
    this();
    this.employee = employee;
    this.course = course;
    registrationStatus = RegistrationStatus.ACCEPTED;
  }

  public void cancel(){
    registrationStatus = RegistrationStatus.CANCEL_ACCEPTED;
  }

  public void confirm(){
    registrationStatus = RegistrationStatus.CONFIRMED;
  }

  public boolean isConfirmed(){
    return registrationStatus == RegistrationStatus.CONFIRMED;
  }

  public boolean isCancelled(){
    return registrationStatus == RegistrationStatus.CANCEL_ACCEPTED;
  }
  @Override
  public Map<IdGenerationKey, String> getIdGenerationData() {
    Map<IdGenerationKey, String> map = new HashMap<>();
    map.put(IdGenerationKey.PREFIX, "REG-COURSE-");
    map.put(IdGenerationKey.SUFFIX, employee.getName() + Constants.HYPHEN + course.getName());
    return map;
  }

  public Course getCourse(){
    return course;
  }

  public Employee getEmployee(){
    return employee;
  }

  public RegistrationStatus getRegistrationStatus(){
    return registrationStatus;
  }

}
