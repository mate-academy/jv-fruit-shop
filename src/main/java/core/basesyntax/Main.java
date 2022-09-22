package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceHandlerImpl;
import core.basesyntax.strategy.handlers.PurchaseHandlerImpl;
import core.basesyntax.strategy.handlers.ReturnHandlerImpl;
import core.basesyntax.strategy.handlers.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/fruits.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> fileData = readerService.readFromFile(INPUT_FILE_PATH);
        FruitTransactionService transactionService = new FruitTransactionServiceImpl();
        Map<Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        operationHandlersMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        operationHandlersMap.put(Operation.RETURN, new ReturnHandlerImpl());
        operationHandlersMap.put(Operation.SUPPLY, new SupplyHandlerImpl());
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlersMap);
        List<FruitTransaction> transactions = transactionService.parseFruitTransactions(fileData);
        for (FruitTransaction fruitTransaction : transactions) {
            OperationHandler operationHandler = strategy
                    .getOperationHandler(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }
        ReportService reportService = new CsvReportServiceImpl();
        String report = reportService.createReport(Storage.storage);
        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
