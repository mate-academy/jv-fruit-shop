package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ProcessInputService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ProcessInputServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    private static String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> inputList = fileReaderService.readFromFile(INPUT_FILE_PATH);
        ProcessInputService processInputService = new ProcessInputServiceImpl();
        processInputService.parseInput(inputList);
        ReportCreator csvReportCreator = new ReportCreatorImpl();
        String report = csvReportCreator.createReport();
        FileWriterService fileWriterServiceImpl = new FileWriterServiceImpl();
        fileWriterServiceImpl.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
