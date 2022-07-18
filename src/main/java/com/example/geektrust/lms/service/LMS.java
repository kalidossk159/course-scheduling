package com.example.geektrust.lms.service;

import com.example.geektrust.allotment.pojo.AllotmentInput;
import com.example.geektrust.course.pojo.CourseAdditionInput;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.lms.pojo.LMSOutput;
import com.example.geektrust.registration.pojo.CancellationInput;
import com.example.geektrust.registration.pojo.RegistrationInput;

public interface LMS {

  public LMSOutput process(LMSInput lmsInput);

  public LMSOutput addCourse(CourseAdditionInput lmsInput);

  public LMSOutput registerForCourse(RegistrationInput lmsInput);

  public LMSOutput cancelRegistrationForCourse(CancellationInput lmsInput);

  public LMSOutput allotCourse(AllotmentInput lmsInput);

}
