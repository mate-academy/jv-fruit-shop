package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.operation.BalanceHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseHandler;
import core.basesyntax.operation.ReturnHandler;
import core.basesyntax.operation.SupplyHandler;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StorageActionsServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String readFromPath = "src/main/java/resources/inputFileExample.csv";
        final String writeToPath = "src/main/java/resources/outputFileExample.csv";

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());

        ReaderService readerService = new ReaderServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        WriterService writerService = new WriterServiceImpl();
        FruitTransaction fruitTransaction = new FruitTransactionImpl(strategy,
                new StorageActionsServiceImpl());

        List<String> dayStatistics = readerService.readFromFile(readFromPath);
        fruitTransaction.processData(dayStatistics);
        String report = reportService.generate();
        writerService.writeToFile(report, writeToPath);
    }
}
