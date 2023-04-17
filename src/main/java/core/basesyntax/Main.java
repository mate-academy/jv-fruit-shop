package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriteToFileServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import core.basesyntax.strategy.impl.TransactionHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH =
            "src/main/resources/inputData.csv";
    private static final String OUTPUT_PATH =
            "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationsHandlerMap = new HashMap<>();
        operationsHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationsHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationsHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationsHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());

        ReadFromFileService readService = new ReadFromFileServiceImpl();
        List<String> fruitTransactions = readService.readCsv(INPUT_PATH);

        TransactionService operationService = new TransactionServiceImpl();
        List<FruitTransaction> transactionsList = operationService
                .createTransactionsList(fruitTransactions);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsHandlerMap);
        TransactionHandler operationHandler = new TransactionHandlerImpl(operationStrategy);
        operationHandler.parse(transactionsList);
        Storage storage = new Storage();
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();

        WriteToFileService writeToFileService = new WriteToFileServiceImpl();
        writeToFileService.writeToFile(OUTPUT_PATH, report);
    }
}
