package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportsServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.List;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/database.csv";
    public static final String OUTPUT_FILE = "src/main/resources/result.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        StorageService storageService = new StorageServiceImpl();
        ReportService reportService = new ReportsServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        List<String> dateFromFile = fileService.readFromFile(INPUT_FILE);
        List<String[]> parsedInputDate = transactionParser.parseInputDate(dateFromFile);
        storageService.fillStorage(parsedInputDate);
        String report = reportService.createReport();
        fileService.writeToFile(OUTPUT_FILE, report);
    }
}
