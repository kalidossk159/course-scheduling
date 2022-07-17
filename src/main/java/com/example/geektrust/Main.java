package com.example.geektrust;

import com.example.geektrust.exception.LMSException;
import com.example.geektrust.file.util.FileUtil;
import com.example.geektrust.file.processor.FileParser;
import com.example.geektrust.file.processor.FileParserFactory;
import com.example.geektrust.file.processor.pojo.FileParserInput;
import com.example.geektrust.lms.pojo.LMSInput;
import com.example.geektrust.lms.service.LMS;
import com.example.geektrust.manage.bean.BeanManager;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File(args[0]);
            List<LMSInput> lmsInputs = parseInputFile(inputFile);
            process(lmsInputs);
        } catch (LMSException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private static List<LMSInput> parseInputFile(File inputFile){
        String inputFileExtension = FileUtil.getFileExtension(inputFile.getName());
        FileParser inputFileParser = FileParserFactory.getInstance(inputFileExtension);
        FileParserInput fileParserInput = new FileParserInput(inputFile);
        return inputFileParser.parse(fileParserInput);
    }

    private static void process(List<LMSInput> lmsInputs){
        LMS intuitLms = BeanManager.getLMSInstance();
        lmsInputs.stream().forEach(lmsInput -> {
            try {
                if(!lmsInput.hasParseError()){
                    intuitLms.process(lmsInput);
                }
                else {
                    System.out.println(lmsInput.getParseErrorMessage());
                }
            }
            catch (LMSException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println(e);
            }
        });
    }
}
