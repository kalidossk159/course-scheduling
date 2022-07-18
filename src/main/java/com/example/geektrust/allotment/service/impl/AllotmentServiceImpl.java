package com.example.geektrust.allotment.service.impl;

import static com.example.geektrust.constant.CharacterConstants.NEWLINE;
import static com.example.geektrust.constant.CharacterConstants.WHITESPACE;

import com.example.geektrust.allotment.pojo.AllotmentInput;
import com.example.geektrust.allotment.service.AllotmentService;
import com.example.geektrust.course.entity.Course;
import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.employee.entity.Employee;
import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.Id;
import com.example.geektrust.lms.pojo.LMSOutput;
import com.example.geektrust.manage.bean.BeanManager;
import com.example.geektrust.registration.entity.Registration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AllotmentServiceImpl implements AllotmentService {

  private final DataStore dataStore = BeanManager.getDataStore();
  @Override
  public LMSOutput allotCourse(AllotmentInput allotmentInput) {
    Id<?> courseId = new Id<>(allotmentInput.getCourseId());
    List<Registration> courseRegistrations = getRegistrationsForCourse(courseId);
    String output = confirmRegistrationsAndGetOutput(courseId, courseRegistrations);
    return new LMSOutput(output);
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

  private String confirmRegistrationsAndGetOutput(Id<?> courseId, List<Registration> registrations){
    Course registeredCourse = findCourseById(courseId);
    StringBuilder outputBuilder = new StringBuilder();
    boolean canAllotCourse = registeredCourse.getMin() <= registrations.size();
    for(Registration registration : registrations){
      if (canAllotCourse) {
        registration.confirm();
      } else {
        registration.cancelCourse();
      }
      Employee registeredEmployee = registration.getEmployee();
      appendWithWhitespace(outputBuilder, registration.getId().toString(), WHITESPACE);
      appendWithWhitespace(outputBuilder, registeredEmployee.getEmail(), WHITESPACE);
      appendWithWhitespace(outputBuilder, registeredCourse.getId().toString(), WHITESPACE);
      appendWithWhitespace(outputBuilder, registeredCourse.getName(), WHITESPACE);
      appendWithWhitespace(outputBuilder, registeredCourse.getInstructor(), WHITESPACE);
      appendWithWhitespace(outputBuilder, registeredCourse.getDate(), WHITESPACE);
      appendWithWhitespace(outputBuilder, registration.getRegistrationStatus().name(), NEWLINE);
    }
    return outputBuilder.toString().trim();
  }

  private void appendWithWhitespace(StringBuilder stringBuilder, String data, String whitespace){
    stringBuilder.append(data).append(whitespace);
  }

}
