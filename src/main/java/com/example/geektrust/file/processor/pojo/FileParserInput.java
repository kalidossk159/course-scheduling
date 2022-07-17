package com.example.geektrust.file.processor.pojo;

import java.io.File;

public class FileParserInput {

  private File file;

  public FileParserInput(File file){
    this.file = file;
  }

  public File getFile(){
    return file;
  }

}
