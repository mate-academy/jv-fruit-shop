package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ProcessInputService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.CsvReportCreator;
import java.util.List;

public class Main {
    private static String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new CsvFileReaderService();
        List<String> inputList = fileReaderService.readFromFile(INPUT_FILE_PATH);
        ProcessInputService processInputService = new ProcessInputService();
        processInputService.parseInput(inputList);
        CsvReportCreator csvReportCreator = new CsvReportCreator();
        String report = csvReportCreator.getReport();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterService();
        csvFileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
