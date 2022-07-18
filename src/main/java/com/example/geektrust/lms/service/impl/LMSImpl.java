package com.example.geektrust.lms.service.impl;

import com.example.geektrust.allotment.pojo.AllotmentInput;
import com.example.geektrust.allotment.service.AllotmentService;
import com.example.geektrust.course.pojo.CourseAdditionInput;
import com.example.geektrust.course.service.CourseService;
import com.example.geektrust.exception.LMSException;
import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.lms.pojo.LMSOutput;
import com.example.geektrust.lms.service.LMS;
import com.example.geektrust.manage.bean.BeanManager;
import com.example.geektrust.message.Message;
import com.example.geektrust.registration.pojo.CancellationInput;
import com.example.geektrust.registration.pojo.RegistrationInput;
import com.example.geektrust.registration.service.RegistrationService;

public class LMSImpl implements LMS {

  @Override
  public LMSOutput process(LMSInput lmsInput) {
    LMSCommand lmsCommand = lmsInput.getLMSCommand();
    switch (lmsCommand){
      case ADD_COURSE_OFFERING:
        return addCourse((CourseAdditionInput) lmsInput);
      case REGISTER:
        return registerForCourse((RegistrationInput) lmsInput);
      case CANCEL:
        return cancelRegistrationForCourse((CancellationInput) lmsInput);
      case ALLOT:
        return allotCourse((AllotmentInput) lmsInput);
      default:
        throw new LMSException(Message.INPUT_DATA_ERROR);
    }
  }

  @Override
  public LMSOutput addCourse(CourseAdditionInput courseAdditionInput) {
    CourseService courseService = BeanManager.getCourseService();
    return courseService.addCourse(courseAdditionInput);
  }

  @Override
  public LMSOutput registerForCourse(RegistrationInput registrationInput) {
    RegistrationService registrationService = BeanManager.getRegistrationService();
    return registrationService.register(registrationInput);
  }

  @Override
  public LMSOutput cancelRegistrationForCourse(CancellationInput cancellationInput) {
    RegistrationService registrationService = BeanManager.getRegistrationService();
    return registrationService.cancel(cancellationInput);
  }

  @Override
  public LMSOutput allotCourse(AllotmentInput allotmentInput) {
    AllotmentService allotmentService = BeanManager.getAllotmentService();
    return allotmentService.allotCourse(allotmentInput);
  }

}
