package com.example.geektrust.registration.service.impl;

import com.example.geektrust.course.entity.Course;
import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.employee.entity.Employee;
import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.Id;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.manage.bean.BeanManager;
import com.example.geektrust.message.Message;
import com.example.geektrust.registration.entity.Registration;
import com.example.geektrust.registration.service.RegistrationService;
import java.util.List;

public class IntuitRegistrationServiceImpl  implements RegistrationService {

  private final DataStore dataStore = BeanManager.getDataStore();
  @Override
  public void register(LMSInput lmsInput) {
    String params[] = lmsInput.getParams();
    Course course = (Course) dataStore.find(new Id<>(params[1]), EntityType.COURSE);

    if(isRegistrationPossible(course)){
      Employee employee = new Employee(params[0]);
      Registration registration = new Registration(employee, course);
      dataStore.insert(registration);
      System.out.println(registration.getId() + " " + registration.getRegistrationStatus());
    }
    else {
      System.out.println(Message.COURSE_FULL);
    }

  }

  @Override
  public void deregister(LMSInput lmsInput) {
    String params[] = lmsInput.getParams();
    String registrationId = params[0];
    Registration registration = (Registration) dataStore.find(new Id<>(registrationId), EntityType.REGISTRATION);
    if(registration == null || registration.isConfirmed()){
      System.out.println(registrationId + " " + Message.CANCEL_REJECTED);
    }
    else {
      registration.cancel();
      System.out.println(registrationId + " " + registration.getRegistrationStatus());
    }
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
