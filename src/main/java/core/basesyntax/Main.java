package core.basesyntax;

import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.WriteToFileServiceImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";

    public static void main(String[] args) {
        ReadFromFileService readService = new ReadFromFileServiceImpl();
        DataProcessingService processingService = new DataProcessingServiceImpl();
        CreateReportService reportService = new CreateReportServiceImpl();
        WriteToFileService writeService = new WriteToFileServiceImpl();

        List<String> list = readService.readFromFile(PATH_TO_INPUT_FILE);
        processingService.processing(list);
        String report = reportService.createReport();
        writeService.writeToFile(report);
    }
}
