package com.example.geektrust.file.parser.impl.txt.validation;

import com.example.geektrust.exception.LMSException;
import com.example.geektrust.message.Message;
import com.example.geektrust.validation.ValidationRule;
import org.apache.commons.lang3.math.NumberUtils;

public class CourseAdditionValidationRule implements ValidationRule<String[]> {

  private final int REQUIRED_PARAMS = 5;
  private final int MIN_INDEX = 3;

  @Override
  public void validate(String[] params) {
    if(params == null || params.length < REQUIRED_PARAMS)
      throw new LMSException(Message.INPUT_DATA_ERROR);
    if(!NumberUtils.isParsable(params[MIN_INDEX]) || !NumberUtils.isParsable(params[MIN_INDEX]))
      throw new LMSException(Message.INPUT_DATA_ERROR);
  }

}
