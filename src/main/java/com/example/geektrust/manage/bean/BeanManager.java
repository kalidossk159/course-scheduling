package com.example.geektrust.manage.bean;

import com.example.geektrust.allotment.service.AllotmentService;
import com.example.geektrust.allotment.service.impl.AllotmentServiceImpl;
import com.example.geektrust.course.service.CourseService;
import com.example.geektrust.course.service.impl.CourseServiceImpl;
import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.datastore.impl.InMemoryDataStore;
import com.example.geektrust.lms.service.LMS;
import com.example.geektrust.lms.service.impl.LMSImpl;
import com.example.geektrust.registration.service.RegistrationService;
import com.example.geektrust.registration.service.impl.RegistrationServiceImpl;

public class BeanManager {

  private BeanManager(){}

  public static LMS getLMSInstance(){
    return new LMSImpl();
  }

  public static AllotmentService getAllotmentService(){
    return new AllotmentServiceImpl();
  }

  public static RegistrationService getRegistrationService(){
    return new RegistrationServiceImpl();
  }

  public static CourseService getCourseService(){
    return new CourseServiceImpl();
  }

  public static DataStore getDataStore(){
    return InMemoryDataStore.getInstance();
  }
}
