package com.example.geektrust.registration.validation;

import com.example.geektrust.exception.LMSException;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.message.Message;
import com.example.geektrust.validation.ValidationRule;

public class DeregistrationValidationRule implements ValidationRule<LMSInput> {

  private final int REQUIRED_PARAMS = 1;
  @Override
  public void validate(LMSInput input) {
    String[] params = input.getParams();
    if(params.length < 1)
      throw new LMSException(Message.INPUT_DATA_ERROR);
  }

}
