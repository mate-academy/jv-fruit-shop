package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.service.FileParserService;
import core.basesyntax.db.service.FileReaderService;
import core.basesyntax.db.service.FileWriterService;
import core.basesyntax.db.service.ReportCreatorService;
import core.basesyntax.db.service.impl.FileParserServiceImpl;
import core.basesyntax.db.service.impl.FileReaderServiceImpl;
import core.basesyntax.db.service.impl.FileWriterServiceImpl;
import core.basesyntax.db.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.db.strategy.OperationHandler;
import core.basesyntax.db.strategy.OperationStrategy;
import core.basesyntax.db.strategy.handler.impl.BalanceOperationHandler;
import core.basesyntax.db.strategy.handler.impl.OperationStrategyImpl;
import core.basesyntax.db.strategy.handler.impl.PurchaseOperationHandler;
import core.basesyntax.db.strategy.handler.impl.ReturnOperationHandler;
import core.basesyntax.db.strategy.handler.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_FROM = "src/main/resources/input.csv";
    private static final String FILE_PATH_TO = "src/main/resources/report.csv";
    private static final FileReaderService service = new FileReaderServiceImpl();
    private static final FileParserService fruitParserService = new FileParserServiceImpl();
    private static final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap = new HashMap<>();
    private static final Map<String, Integer> map = Storage.getStorage();
    private static final ReportCreatorService createReport = new ReportCreatorServiceImpl();
    private static final FileWriterService reportFile = new FileWriterServiceImpl();

    static {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
    }

    public static void main(String[] args) {
        List<String> strings = service.readFromFile(FILE_PATH_FROM);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = fruitParserService.parse(strings);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction);
        }
        String report = createReport.getReport(map);
        reportFile.writeToFile(report, FILE_PATH_TO);
    }
}

