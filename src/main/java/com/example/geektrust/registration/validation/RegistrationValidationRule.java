package com.example.geektrust.registration.validation;

import com.example.geektrust.constant.Constants;
import com.example.geektrust.exception.LMSException;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.message.Message;
import com.example.geektrust.validation.ValidationRule;

public class RegistrationValidationRule implements ValidationRule<LMSInput> {

  private final int REQUIRED_PARAMS = 2;
  private final int EMAIL_INDEX = 0;

  @Override
  public void validate(LMSInput input) {
    String[] params = input.getParams();
    if(params.length < 2)
      throw new LMSException(Message.INPUT_DATA_ERROR);
    int atIndex = params[EMAIL_INDEX].indexOf(Constants.AT);
    if(atIndex == -1)
      throw new LMSException(Message.INPUT_DATA_ERROR);
  }

}
