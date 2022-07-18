package com.example.geektrust.lms.pojo;

import com.example.geektrust.lms.enums.LMSCommand;

public class LMSInput {

  private LMSCommand lmsCommand;

  private String parseErrorMessage;

  public LMSInput(){}
  public LMSInput(LMSCommand lmsCommand){
    this.lmsCommand = lmsCommand;
  }

  public LMSInput(String parseErrorMessage){
    this.parseErrorMessage = parseErrorMessage;
  }

  public LMSCommand getLMSCommand(){
    return lmsCommand;
  }

  public boolean hasParseError(){
    return parseErrorMessage != null;
  }
  public String getParseErrorMessage(){ return parseErrorMessage; }

}
