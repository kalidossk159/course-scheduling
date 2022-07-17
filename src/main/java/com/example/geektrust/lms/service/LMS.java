package com.example.geektrust.lms.service;

import com.example.geektrust.lms.pojo.LMSInput;

public interface LMS {

  public void process(LMSInput lmsInput);

  public void addCourse(LMSInput lmsInput);

  public void registerForCourse(LMSInput lmsInput);

  public void deregisterFromCourse(LMSInput lmsInput);

  public void allotCourse(LMSInput lmsInput);

}
