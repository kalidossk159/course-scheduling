package com.example.geektrust.registration.pojo;

import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;

public class CancellationInput extends LMSInput {

  private String registrationId;

  public CancellationInput(LMSCommand lmsCommand, String[] params){
    super(lmsCommand);
    registrationId = params[0];
  }

  public String getRegistrationId() {
    return registrationId;
  }

}
