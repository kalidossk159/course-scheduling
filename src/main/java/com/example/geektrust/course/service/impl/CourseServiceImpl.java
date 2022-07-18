package com.example.geektrust.course.service.impl;

import com.example.geektrust.course.entity.Course;
import com.example.geektrust.course.pojo.CourseAdditionInput;
import com.example.geektrust.course.service.CourseService;
import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.lms.pojo.LMSOutput;
import com.example.geektrust.manage.bean.BeanManager;

public class CourseServiceImpl implements CourseService {
  private final DataStore dataStore = BeanManager.getDataStore();
  @Override
  public LMSOutput addCourse(CourseAdditionInput courseAdditionInput) {
    Course course = new Course(courseAdditionInput);
    dataStore.insert(course);
    return new LMSOutput(course.getId().toString());
  }

}
