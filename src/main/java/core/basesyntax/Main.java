package core.basesyntax;

import core.basesyntax.service.DataProcessorService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParseDataService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.DataProcessorServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParseDataServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService readFromFile = new FileReaderServiceImpl();
        ParseDataService parseDataService = new ParseDataServiceImpl();
        DataProcessorService dataProcessorService = new DataProcessorServiceImpl();
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        String data = readFromFile.readFile(INPUT_FILE_PATH);
        List<String[]> list = parseDataService.parseData(data);
        dataProcessorService.processData(list);
        String report = reportCreatorService.createReport();
        fileWriterService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
