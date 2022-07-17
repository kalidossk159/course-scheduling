package com.example.geektrust.file.util;

public class FileUtil {

    private FileUtil(){}
    public static String getFileExtension(String fileName){
      int extensionStartIndex = fileName.lastIndexOf('.') + 1;
      if(extensionStartIndex == 0)
        return "";
      return fileName.substring(extensionStartIndex);
    }

}
