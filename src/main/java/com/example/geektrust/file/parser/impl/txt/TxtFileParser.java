package com.example.geektrust.file.parser.impl.txt;

import com.example.geektrust.constant.Constants;
import com.example.geektrust.exception.LMSException;
import com.example.geektrust.file.parser.FileParser;
import com.example.geektrust.file.parser.pojo.FileParserInput;
import com.example.geektrust.lms.enums.LMSCommand;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.message.Message;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TxtFileParser extends FileParser {

  private static final int COMMAND_INDEX = 0;

  private static final int PARAMS_START_INDEX = 1;

  @Override
  public List<LMSInput> parse(FileParserInput fileParserInput) {
    File file = fileParserInput.getFile();
    try {
      return parseFile(file);
    }
    catch (FileNotFoundException e) {
      throw new LMSException(Message.FILE_NOT_FOUND + file.getName(), e);
    }
  }

  private List<LMSInput> parseFile(File file) throws FileNotFoundException {
    List<LMSInput> lmsInputs = new ArrayList<>();
    FileInputStream fileInputStream = new FileInputStream(file);
    try (Scanner scanner = new Scanner(fileInputStream);){
      while (scanner.hasNextLine()) {
        String inputLine = scanner.nextLine();
        LMSInput lmsInput = createLMSInput(inputLine);
        lmsInputs.add(lmsInput);
      }
    }
    return lmsInputs;
  }

  private LMSInput createLMSInput(String inputLine){
    String[] tokens = inputLine.split(Constants.WHITESPACE);
    if(tokens.length <= PARAMS_START_INDEX){
      return new LMSInput(Message.INPUT_DATA_ERROR);
    }

    LMSCommand lmsCommand = LMSCommand.fromCommand(tokens[COMMAND_INDEX]);
    String[] params = Arrays.copyOfRange(tokens, PARAMS_START_INDEX, tokens.length);
    return TxtInputToLmsInputConverter.convert(lmsCommand, params);
  }

}
