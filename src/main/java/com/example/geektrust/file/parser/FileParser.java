package com.example.geektrust.file.parser;

import com.example.geektrust.file.parser.pojo.FileParserInput;
import com.example.geektrust.lms.pojo.LMSInput;
import java.util.List;

public abstract class FileParser {
    public abstract List<LMSInput> parse(FileParserInput fileParserInput);

}
