package com.example.geektrust.allotment.pojo;

import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;

public class AllotmentInput extends LMSInput {

  private String courseId;

  public AllotmentInput(LMSCommand lmsCommand, String[] params){
    super(lmsCommand);
    courseId = params[0];
  }

  public String getCourseId() {
    return courseId;
  }

}
