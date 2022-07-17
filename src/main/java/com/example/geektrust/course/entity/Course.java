package com.example.geektrust.course.entity;

import com.example.geektrust.constant.Constants;
import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.IdGenerationKey;
import com.example.geektrust.id.StringIdGenerator;
import java.util.HashMap;
import java.util.Map;

public class Course extends Entity<String> {

  String name;

  String instructor;

  String date;

  int min;

  int max;

  public Course(){
    super(EntityType.COURSE, new StringIdGenerator());
  }

  public Course(String name, String instructor, String date, int min, int max){
    this();
    this.name = name;
    this.instructor = instructor;
    this.date = date;
    this.min = min;
    this.max = max;
  }

  @Override
  public Map<IdGenerationKey, String> getIdGenerationData() {
    Map<IdGenerationKey, String> map = new HashMap<>();
    map.put(IdGenerationKey.PREFIX, "OFFERING-");
    map.put(IdGenerationKey.SUFFIX, name + Constants.HYPHEN + instructor);
    return map;
  }

  public String getName(){
    return name;
  }

  public String getInstructor(){
    return instructor;
  }

  public String getDate(){
    return date;
  }

  public int getMin(){
    return min;
  }

  public int getMax(){
    return max;
  }

}
