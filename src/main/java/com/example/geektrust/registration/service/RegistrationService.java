package com.example.geektrust.registration.service;

import com.example.geektrust.lms.pojo.LMSOutput;
import com.example.geektrust.registration.pojo.CancellationInput;
import com.example.geektrust.registration.pojo.RegistrationInput;

public interface RegistrationService {

  public abstract LMSOutput register(RegistrationInput lmsInput);

  public abstract LMSOutput cancel(CancellationInput lmsInput);

}
