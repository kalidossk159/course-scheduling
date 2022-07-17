package com.example.geektrust.lms.pojo;

import com.example.geektrust.lms.enums.LMSCommand;

public class LMSInput {

  private LMSCommand lmsCommand;

  private String[] params;

  private String parseErrorMessage;
  
  public LMSInput(LMSCommand lmsCommand, String... params){
    this.lmsCommand = lmsCommand;
    this.params = params;
  }

  public LMSInput(String parseErrorMessage){
    this.parseErrorMessage = parseErrorMessage;
  }

  public LMSCommand getLMSCommand(){
    return lmsCommand;
  }

  public String[] getParams(){
    return params;
  }

  public boolean hasParseError(){
    return parseErrorMessage != null;
  }
  public String getParseErrorMessage(){
    return parseErrorMessage;
  }
}
