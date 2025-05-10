package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.TransactionProcessorImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.QuantityCounterStrategy;
import core.basesyntax.strategy.QuantityCounterStrategyImpl;
import core.basesyntax.strategy.QuantityCountersMap;
import core.basesyntax.transaction.Transaction;
import java.util.List;

public class Main {
    private static final String STORAGE_FILE_PATH = "src/main/resources/storage.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static Storage storage = new Storage();
    private static QuantityCounterStrategy quantityCounterStrategy =
            new QuantityCounterStrategyImpl(new QuantityCountersMap().getQuantityCountersMap());

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> fileInfo = fileService.readFile(STORAGE_FILE_PATH);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<Transaction> transactions = transactionParser.parse(fileInfo);
        TransactionProcessor processor = new TransactionProcessorImpl(quantityCounterStrategy);
        processor.process(transactions, storage);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(storage.getProductsMap());
        fileService.writeToFile(report, REPORT_FILE_PATH);
    }
}
