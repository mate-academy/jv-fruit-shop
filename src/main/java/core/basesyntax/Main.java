package core.basesyntax;

import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readService = new ReaderServiceImpl();
        DataProcessingService processingService = new DataProcessingServiceImpl();
        ReportCreatorService reportService = new ReportCreatorServiceImpl();
        WriterService writeService = new WriterServiceImpl();

        List<String> list = readService.readFromFile(PATH_TO_INPUT_FILE);
        processingService.processing(list);
        String report = reportService.createReport();
        writeService.writeToFile(report, PATH_TO_REPORT);
    }
}
