package com.example.geektrust.course.validation;

import com.example.geektrust.exception.LMSException;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.message.Message;
import com.example.geektrust.validation.ValidationRule;
import org.apache.commons.lang3.math.NumberUtils;

public class CourseAdditionValidationRule implements ValidationRule<LMSInput> {

  private final int REQUIRED_PARAMS = 5;
  private final int MIN_INDEX = 3;
  private final int MAX_INDEX = 4;

  @Override
  public void validate(LMSInput input) {
    String[] params = input.getParams();
    if(params.length < REQUIRED_PARAMS)
      throw new LMSException(Message.INPUT_DATA_ERROR);
    if(!NumberUtils.isParsable(params[MIN_INDEX]) || !NumberUtils.isParsable(params[MIN_INDEX]))
      throw new LMSException(Message.INPUT_DATA_ERROR);
  }

}
