package com.example.geektrust.course.pojo;

import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;

public class CourseAdditionInput extends LMSInput {

  private String courseName;

  private String instructor;

  private String courseDate;

  private int minEmployees;

  private int maxEmployees;

  public CourseAdditionInput(LMSCommand lmsCommand, String[] params){
    super(lmsCommand);
    courseName = params[0];
    instructor = params[1];
    courseDate = params[2];
    minEmployees = Integer.parseInt(params[3]);
    maxEmployees = Integer.parseInt(params[4]);
  }

  public String getCourseName() {
    return courseName;
  }

  public String getInstructor() {
    return instructor;
  }

  public String getCourseDate() {
    return courseDate;
  }

  public int getMaxEmployees() {
    return maxEmployees;
  }

  public int getMinEmployees() {
    return minEmployees;
  }
}
