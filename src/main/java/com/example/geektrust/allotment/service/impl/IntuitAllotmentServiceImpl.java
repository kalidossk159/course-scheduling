package com.example.geektrust.allotment.service.impl;

import com.example.geektrust.allotment.service.AllotmentService;
import com.example.geektrust.course.entity.Course;
import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.employee.entity.Employee;
import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.Id;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.manage.bean.BeanManager;
import com.example.geektrust.registration.entity.Registration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntuitAllotmentServiceImpl implements AllotmentService {

  private final DataStore dataStore = BeanManager.getDataStore();
  @Override
  public void allotCourse(LMSInput lmsInput) {
    String[] params = lmsInput.getParams();
    Id<?> courseId = new Id<>(params[0]);
    List<Registration> courseRegistrations = getRegistrationsForCourse(courseId);
    confirmRegistrationsAndPrint(courseId, courseRegistrations);
  }

  private Course findCourseById(Id<?> courseId){
    return (Course) dataStore.find(courseId, EntityType.COURSE);
  }
  private List<Registration> getRegistrationsForCourse(Id<?> courseId){
    List<Entity<?>> registrations = dataStore.list(EntityType.REGISTRATION);
    return registrations.stream()
        .filter(entity -> {
          Registration registration = (Registration) entity;
          Course registeredCourse = registration.getCourse();
          return registeredCourse.getId().equals(courseId) && !registration.isCancelled();
        })
        .sorted(Comparator.comparing(a -> a.getId().toString()))
        .map(entity -> (Registration) entity)
        .collect(Collectors.toList());
  }

  private void confirmRegistrationsAndPrint(Id<?> courseId, List<Registration> registrations){
    Course registeredCourse = findCourseById(courseId);
    for(Registration registration : registrations){
      registration.confirm();
      Employee registeredEmployee = registration.getEmployee();
      System.out.println(registration.getId() + " " + registeredEmployee.getEmail() + " " + registration.getId()
          + " " + registeredCourse.getName() + " " + registeredCourse.getInstructor() + " " + registeredCourse.getDate()
          + " " + registration.getRegistrationStatus());
    }
  }
}
