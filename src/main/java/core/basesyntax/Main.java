package core.basesyntax;

import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH
            = "src/main/resources/transaction.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fruitConsider = fileReaderService.readFromFile(INPUT_FILE_PATH);
        DataParserService stringParser = new DataParserServiceImpl();
        stringParser.parseData(fruitConsider);
        ReportCreatorService reportCreator = new ReportCreatorServiceImpl();
        String report = reportCreator.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
