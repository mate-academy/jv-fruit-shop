import service.FileWriterService;
import service.InputDataValidator;
import service.Parse;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.InputDataValidatorImpl;
import service.impl.ParseImpl;

import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/res/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/res/report.csv";

    public static void main(String[] args) {
        FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();
        List<String> strings = fileReaderService.readFile(INPUT_FILE_NAME);

        InputDataValidator validator = new InputDataValidatorImpl();
        validator.chekDate(strings);

        Parse parse = new ParseImpl();
        parse.parseList(strings);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_NAME);
    }
}
