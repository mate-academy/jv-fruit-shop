package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ProcessInputService;
import core.basesyntax.service.ProcessInputServiceImpl;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.ReportCreator;
import java.util.List;

public class Main {
    private static String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new CsvFileReaderService();
        List<String> inputList = fileReaderService.readFromFile(INPUT_FILE_PATH);
        ProcessInputService processInputService = new ProcessInputServiceImpl();
        processInputService.parseInput(inputList);
        ReportCreatorService csvReportCreator = new ReportCreator();
        String report = csvReportCreator.createReport();
        FileWriterService csvFileWriterService = new CsvFileWriterService();
        csvFileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
