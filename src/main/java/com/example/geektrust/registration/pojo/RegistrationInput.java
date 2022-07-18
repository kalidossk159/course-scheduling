package com.example.geektrust.registration.pojo;

import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;

public class RegistrationInput extends LMSInput {

    private String email;

    private String courseId;

    public RegistrationInput(LMSCommand lmsCommand, String[] params){
      super(lmsCommand);
      email = params[0];
      courseId = params[1];
    }

    public String getCourseId() {
      return courseId;
    }

    public String getEmail(){
        return email;
    }
}
