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
    private static final String BALANCE_OPERATION = "b";
    private static final String RETURN_OPERATION = "r";
    private static final String SUPPLY_OPERATION = "s";
    private static final String PURCHASE_OPERATION = "p";
    private static final FileReaderService service = new FileReaderServiceImpl();
    private static final FileParserService fruitParserService = new FileParserServiceImpl();
    private static final Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
    private static final Map<String, Integer> map = Storage.getStorage();
    private static final ReportCreatorService createReport = new ReportCreatorServiceImpl();
    private static final FileWriterService reportFile = new FileWriterServiceImpl();

    static {
        operationHandlerMap.put(BALANCE_OPERATION, new BalanceOperationHandler());
        operationHandlerMap.put(RETURN_OPERATION, new ReturnOperationHandler());
        operationHandlerMap.put(SUPPLY_OPERATION, new SupplyOperationHandler());
        operationHandlerMap.put(PURCHASE_OPERATION, new PurchaseOperationHandler());
    }


    public static void main(String[] args) {
        List<String> strings = service.readFromFile(FILE_PATH_FROM);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = fruitParserService.parse(strings);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation().getOperationByChar());
            operationHandler.apply(fruitTransaction);
        }
        String report = createReport.getReport(map);
        reportFile.writeToFile(report, FILE_PATH_TO);
    }
}

