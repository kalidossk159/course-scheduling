package com.example.geektrust.allotment.service;

import com.example.geektrust.allotment.pojo.AllotmentInput;
import com.example.geektrust.lms.pojo.LMSOutput;

public interface AllotmentService {

  public LMSOutput allotCourse(AllotmentInput lmsInput);

}
