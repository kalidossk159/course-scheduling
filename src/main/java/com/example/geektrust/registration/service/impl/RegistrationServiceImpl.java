package com.example.geektrust.registration.service.impl;

import static com.example.geektrust.constant.CharacterConstants.WHITESPACE;

import com.example.geektrust.course.entity.Course;
import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.employee.entity.Employee;
import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.Id;
import com.example.geektrust.lms.pojo.LMSOutput;
import com.example.geektrust.manage.bean.BeanManager;
import com.example.geektrust.message.Message;
import com.example.geektrust.registration.entity.Registration;
import com.example.geektrust.registration.pojo.CancellationInput;
import com.example.geektrust.registration.pojo.RegistrationInput;
import com.example.geektrust.registration.service.RegistrationService;
import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {

  private final DataStore dataStore = BeanManager.getDataStore();
  @Override
  public LMSOutput register(RegistrationInput registrationInput) {
    Course course = (Course) dataStore.find(new Id<>(registrationInput.getCourseId()), EntityType.COURSE);

    String output;
    if(isRegistrationPossible(course)){
      Employee employee = new Employee(registrationInput.getEmail());
      Registration registration = new Registration(employee, course);
      dataStore.insert(registration);
      output = registration.getId() + WHITESPACE + registration.getRegistrationStatus();
    }
    else {
      output = Message.COURSE_FULL;
    }

    return new LMSOutput(output);
  }

  @Override
  public LMSOutput cancel(CancellationInput cancellationInput) {
    String registrationId = cancellationInput.getRegistrationId();
    Registration registration = (Registration) dataStore.find(new Id<>(registrationId), EntityType.REGISTRATION);

    String output;
    if(registration == null || registration.isConfirmed()){
      output = registrationId + WHITESPACE + Message.CANCEL_REJECTED;
    }
    else {
      registration.cancel();
      output = registrationId + WHITESPACE + registration.getRegistrationStatus();
    }

    return new LMSOutput(output);
  }

  private boolean isRegistrationPossible(Course course){
    List<Entity<?>> entities = dataStore.list(EntityType.REGISTRATION);
    long count = entities.stream()
        .filter(entity -> {
          Registration registration = (Registration) entity;
          return registration.getCourse().equals(course);
        })
        .count();
    return count < course.getMax();
  }

}
