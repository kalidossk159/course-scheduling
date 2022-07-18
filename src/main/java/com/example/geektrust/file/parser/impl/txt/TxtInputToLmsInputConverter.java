package com.example.geektrust.file.parser.impl.txt;

import com.example.geektrust.allotment.pojo.AllotmentInput;
import com.example.geektrust.course.pojo.CourseAdditionInput;
import com.example.geektrust.exception.LMSException;
import com.example.geektrust.file.parser.impl.txt.validation.AllotmentValidationRule;
import com.example.geektrust.file.parser.impl.txt.validation.CancellationValidationRule;
import com.example.geektrust.file.parser.impl.txt.validation.CourseAdditionValidationRule;
import com.example.geektrust.file.parser.impl.txt.validation.RegistrationValidationRule;
import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.message.Message;
import com.example.geektrust.registration.pojo.CancellationInput;
import com.example.geektrust.registration.pojo.RegistrationInput;

public class TxtInputToLmsInputConverter {

  public static LMSInput convert(LMSCommand command, String[] params){
    try {
      switch (command) {
        case ADD_COURSE_OFFERING:
          new CourseAdditionValidationRule().validate(params);
          return new CourseAdditionInput(command, params);
        case REGISTER:
          new RegistrationValidationRule().validate(params);
          return new RegistrationInput(command, params);
        case CANCEL:
          new CancellationValidationRule().validate(params);
          return new CancellationInput(command, params);
        case ALLOT:
          new AllotmentValidationRule().validate(params);
          return new AllotmentInput(command, params);
        default:
          return new LMSInput(Message.INPUT_DATA_ERROR);
      }
    }
    catch (LMSException e){
      return new LMSInput(e.getMessage());
    }
  }

}
