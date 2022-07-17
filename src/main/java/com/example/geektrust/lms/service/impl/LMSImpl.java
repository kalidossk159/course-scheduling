package com.example.geektrust.lms.service.impl;

import com.example.geektrust.allotment.service.AllotmentService;
import com.example.geektrust.course.service.CourseService;
import com.example.geektrust.course.validation.CourseAdditionValidationRule;
import com.example.geektrust.exception.LMSException;
import com.example.geektrust.lms.service.LMS;
import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.manage.bean.BeanManager;
import com.example.geektrust.message.Message;
import com.example.geektrust.registration.service.RegistrationService;
import com.example.geektrust.registration.validation.AllotmentValidationRule;
import com.example.geektrust.registration.validation.DeregistrationValidationRule;
import com.example.geektrust.registration.validation.RegistrationValidationRule;
import com.example.geektrust.validation.ValidationRule;

public class LMSImpl implements LMS {

  @Override
  public void process(LMSInput lmsInput) {
    LMSCommand lmsCommand = lmsInput.getLMSCommand();
    switch (lmsCommand){
      case ADD_COURSE_OFFERING:
        addCourse(lmsInput);
        break;
      case REGISTER:
        registerForCourse(lmsInput);
        break;
      case CANCEL:
        deregisterFromCourse(lmsInput);
        break;
      case ALLOT:
        allotCourse(lmsInput);
        break;
      default:
        throw new LMSException(Message.INPUT_DATA_ERROR);
    }
  }

  @Override
  public void addCourse(LMSInput lmsInput) {
    ValidationRule<LMSInput> validationRule = new CourseAdditionValidationRule();
    validationRule.validate(lmsInput);

    CourseService courseService = BeanManager.getCourseService();
    courseService.addCourse(lmsInput);
  }

  @Override
  public void registerForCourse(LMSInput lmsInput) {
    ValidationRule<LMSInput> validationRule = new RegistrationValidationRule();
    validationRule.validate(lmsInput);

    RegistrationService registrationService = BeanManager.getRegistrationService();
    registrationService.register(lmsInput);
  }

  @Override
  public void deregisterFromCourse(LMSInput lmsInput) {
    ValidationRule<LMSInput> validationRule = new DeregistrationValidationRule();
    validationRule.validate(lmsInput);

    RegistrationService registrationService = BeanManager.getRegistrationService();
    registrationService.deregister(lmsInput);
  }

  @Override
  public void allotCourse(LMSInput lmsInput) {
    ValidationRule<LMSInput> validationRule = new AllotmentValidationRule();
    validationRule.validate(lmsInput);

    AllotmentService allotmentService = BeanManager.getAllotmentService();
    allotmentService.allotCourse(lmsInput);
  }

}
