package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportsServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/main/resources/database.csv";
        final String outputFile = "src/main/resources/result.csv";

        ReaderService readerService = new ReaderServiceImpl();
        StorageService storageService = new StorageServiceImpl();
        ReportService reportService = new ReportsServiceImpl();
        WriterService writerService = new WriteServiceImpl();
        List<String> dateFromFile = readerService.readFromFile(inputFile);
        storageService.fillStorage(dateFromFile);
        String report = reportService.createReport();
        writerService.writeToFile(outputFile, report);

    }
}
