package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionHandlerImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceTransactionHandlerImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseTransactionHandlerImpl;
import core.basesyntax.strategy.impl.ReturnTransactionHandlerImpl;
import core.basesyntax.strategy.impl.SupplyTransactionHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE
            = "src/main/java/core/basesyntax/resources/inputFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandlerImpl());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> input = readerService.readFromFile(INPUT_FILE);

        TransactionService transactionService = new TransactionServiceImpl();
        List<FruitTransaction> fruitTransactions = transactionService.toTransaction(input);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(operationStrategy);
        transactionHandler.parse(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report);
    }
}
