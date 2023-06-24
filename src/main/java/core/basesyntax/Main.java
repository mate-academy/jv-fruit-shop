package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.BalanceTransactionHandler;
import core.basesyntax.service.impl.PurchaseTransactionHandler;
import core.basesyntax.service.impl.ReturnTransactionHandler;
import core.basesyntax.service.impl.SupplyTransactionHandler;
import core.basesyntax.service.impl.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String TRANSACTION_OF_DAY = "src/main/resources/movementPerDay.csv";
    private static final String DAILY_REPORT = "src/main/resources/dailyReport.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation,
                TransactionHandler> transactionHandlersMap = new HashMap<>();
        transactionHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandler());
        transactionHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler());
        transactionHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler());
        transactionHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(transactionHandlersMap);
        FileService fileService = new FileServiceImpl();
        FruitService fruitService = new FruitServiceImpl();
        TransactionParser transactionParser = new TransactionParser();
        List<FruitTransaction> fruitTransactionList = transactionParser
                .parseTransactions(fileService.read(TRANSACTION_OF_DAY));
        ReportService reportService = new ReportService();
        StorageService storageService = new StorageServiceImpl(operationStrategy, fruitService);
        storageService.processTransactions(fruitTransactionList);
        fileService.write(reportService.getReport(), DAILY_REPORT);
        System.out.println(reportService.getReport());
    }
}
