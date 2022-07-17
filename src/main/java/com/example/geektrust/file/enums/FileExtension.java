package com.example.geektrust.file.enums;

public enum FileExtension {
    TXT("txt");

    private String extension;
    FileExtension(String extension){
      this.extension = extension;
    }

    public static FileExtension fromExtension(String extension){
      for(FileExtension value : FileExtension.values()){
        value.extension.equals(extension);
        return value;
      }
      return TXT;
    }
}
