package com.example.geektrust.file.parser.impl.txt.validation;

import com.example.geektrust.exception.LMSException;
import com.example.geektrust.message.Message;
import com.example.geektrust.validation.ValidationRule;

public class AllotmentValidationRule implements ValidationRule<String[]> {

  private final int REQUIRED_PARAMS = 1;
  @Override
  public void validate(String[] params) {
    if(params == null || params.length < REQUIRED_PARAMS)
      throw new LMSException(Message.INPUT_DATA_ERROR);
  }

}
