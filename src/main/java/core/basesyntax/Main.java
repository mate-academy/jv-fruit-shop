package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceOperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperationHandler;
import core.basesyntax.strategy.operations.ReturnOperationHandler;
import core.basesyntax.strategy.operations.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/storeActivities.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationStrategyMap.put(Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        ReaderService readerService = new ReaderServiceImpl();
        List<String> activities = readerService.readFromFile(PATH_TO_READ);
        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> transactions = parseService.parseStringsToTransactions(activities);
        for (FruitTransaction transaction : transactions) {
            operationStrategy.get(transaction.getOperation()).handle(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(PATH_TO_WRITE, report);
    }
}
