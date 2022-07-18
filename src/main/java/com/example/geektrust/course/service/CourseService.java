package com.example.geektrust.course.service;

import com.example.geektrust.course.pojo.CourseAdditionInput;
import com.example.geektrust.lms.pojo.LMSOutput;

public interface CourseService {

  public LMSOutput addCourse(CourseAdditionInput lmsInput);

}
