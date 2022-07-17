package com.example.geektrust.file.processor;

import com.example.geektrust.file.enums.FileExtension;
import com.example.geektrust.file.processor.impl.TxtFileParser;

public class FileParserFactory {

  private FileParserFactory(){}
  public static FileParser getInstance(String fileExtension){
    FileExtension fileExtensionEnum = FileExtension.fromExtension(fileExtension);
    switch (fileExtensionEnum){
      case TXT:
      default:
        return new TxtFileParser();
    }
  }

}
