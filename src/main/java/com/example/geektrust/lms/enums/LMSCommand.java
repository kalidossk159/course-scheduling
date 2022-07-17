package com.example.geektrust.lms.enums;

public enum LMSCommand {

  ADD_COURSE_OFFERING("ADD-COURSE-OFFERING"),
  REGISTER("REGISTER"),
  CANCEL("CANCEL"),
  ALLOT("ALLOT"),
  NONE("NONE");
  private String command;
  LMSCommand(String command){
    this.command = command;
  }
  public static LMSCommand fromCommand(String command){
    for(LMSCommand lmsCommand : values()){
      if(lmsCommand.command.equals(command))
        return lmsCommand;
    }
    return NONE;
  }

}
