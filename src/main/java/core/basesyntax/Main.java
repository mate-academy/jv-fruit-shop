package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceImpl.ParseServiceImpl;
import core.basesyntax.serviceImpl.ReaderServiceImpl;
import core.basesyntax.serviceImpl.ReportServiceImpl;
import core.basesyntax.serviceImpl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/storeActivities.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> activities = readerService.readFromFile(PATH_TO_READ);
        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> transactions = parseService.parseStringsToTransactions(activities);
        for (FruitTransaction transaction : transactions) {
            OperationStrategy.getOperations(transaction.getOperation())
                    .doOperation(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(PATH_TO_WRITE, report);
    }
}
