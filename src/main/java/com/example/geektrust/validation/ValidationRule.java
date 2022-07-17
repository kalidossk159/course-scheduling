package com.example.geektrust.validation;

public interface ValidationRule<T> {

  public void validate(T input);

}
