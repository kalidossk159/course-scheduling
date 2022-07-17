package com.example.geektrust.file.processor;

import com.example.geektrust.file.processor.pojo.FileParserInput;
import com.example.geektrust.lms.pojo.LMSInput;
import java.util.List;

public abstract class FileParser {
    public abstract List<LMSInput> parse(FileParserInput fileParserInput);

}
