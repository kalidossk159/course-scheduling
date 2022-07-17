package com.example.geektrust.exception;

public class LMSException extends RuntimeException{

  public LMSException(String message){
    super(message);
  }
  public LMSException(String message, Exception cause){
    super(message, cause);
  }

}
