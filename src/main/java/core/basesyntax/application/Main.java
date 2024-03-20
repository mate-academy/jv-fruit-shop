package core.basesyntax.application;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final StorageService storageService = new StorageServiceImpl();
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operations = new HashMap<>();
        operations.put("b", new BalanceOperation());
        operations.put("s", new SupplyOperation());
        operations.put("r", new ReturnOperation());
        operations.put("p", new PurchaseOperation());

        var readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromFile(INPUT_FILE_PATH);

        var fileDataParser = new TransactionParserImpl();
        List<Transaction> transactions = fileDataParser.parse(data);

        var operatingStrategy = new OperationStrategyImpl(operations);
        var transactionProcessor = new TransactionProcessorImpl(operatingStrategy);
        transactionProcessor.executeTransactions(transactions);

        var reportService = new ReportServiceImpl(storageService);
        List<String> report = reportService.generateReport();

        var writerService = new WriterServiceImpl();
        writerService.writeToFile(report, REPORT_FILE_PATH);
    }
}
