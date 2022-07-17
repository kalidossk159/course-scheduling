package com.example.geektrust.course.service.impl;

import com.example.geektrust.course.entity.Course;
import com.example.geektrust.course.service.CourseService;
import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.manage.bean.BeanManager;

public class IntuitCourseServiceImpl implements CourseService {
  private final DataStore dataStore = BeanManager.getDataStore();
  @Override
  public void addCourse(LMSInput lmsInput) {
    String[] params = lmsInput.getParams();
    Course course = new Course(params[0], params[1], params[2], Integer.parseInt(params[3]), Integer.parseInt(params[4]));
    dataStore.insert(course);
    System.out.println(course.getId());
  }

}
