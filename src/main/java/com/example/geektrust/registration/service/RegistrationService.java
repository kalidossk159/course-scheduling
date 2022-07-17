package com.example.geektrust.registration.service;

import com.example.geektrust.lms.pojo.LMSInput;

public interface RegistrationService {

  public abstract void register(LMSInput lmsInput);

  public abstract void deregister(LMSInput lmsInput);

}
