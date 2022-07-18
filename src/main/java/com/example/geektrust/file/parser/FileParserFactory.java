package com.example.geektrust.file.parser;

import com.example.geektrust.file.enums.FileExtension;
import com.example.geektrust.file.parser.impl.txt.TxtFileParser;

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
