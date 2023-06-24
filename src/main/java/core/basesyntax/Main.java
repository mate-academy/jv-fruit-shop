package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionHandlerImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.str.OperationHandler;
import core.basesyntax.str.OperationStrategy;
import core.basesyntax.str.impl.BalanceOperationHandler;
import core.basesyntax.str.impl.BuyOperationHandler;
import core.basesyntax.str.impl.OperationStrategyImpl;
import core.basesyntax.str.impl.ReturnOperationHandler;
import core.basesyntax.str.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new BuyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> inputData = readerService.readFromFile(INPUT_FILE_PATH);

        TransactionService transactionService = new TransactionServiceImpl();
        List<FruitTransaction> fruitTransactions = transactionService.toTransaction(inputData);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(operationStrategy);
        transactionHandler.parse(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report();
        System.out.println(report);

        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(report);

    }
}
