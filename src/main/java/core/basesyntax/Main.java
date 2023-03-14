package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseDataHandlerImpl;
import core.basesyntax.service.impl.ParseDataServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.BuyOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH
            = pathFix("src/main/java/core/basesyntax/resources/fruits.csv");
    private static final String OUT_FILE_PATH
            = pathFix("src/main/java/core/basesyntax/resources/report.csv");

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new BuyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());

        ReaderService readerService = new ReaderServiceImpl();
        ParseDataService parseDataService = new ParseDataServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionHandler transactionHandler = new ParseDataHandlerImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> inputData = readerService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = parseDataService.parseData(inputData);
        transactionHandler.parse(fruitTransactions);
        String report = reportService.report();
        System.out.println(report);
        writerService.writeToFile(OUT_FILE_PATH, report);
    }

    private static String pathFix(String path) {
        path = path.replace("\\", File.separator);
        path = path.replace("/", File.separator);
        return path;
    }
}
