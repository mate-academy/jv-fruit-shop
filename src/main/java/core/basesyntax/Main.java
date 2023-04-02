package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.enums.Operation;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.TransactionParseService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.TransactionParseServiceImpl;
import core.basesyntax.service.impl.WriteToFileServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String START_FILE_PATH = "src/main/resources/startFile.csv";
    private static final String RESULT_FILE_PATH = "src/main/resources/resultFile.csv";
    private static final int APPLE_QUANTITY = 1000;
    private static final int BANANA_QUANTITY = 2000;
    private static final int ORANGE_QUANTITY = 500;

    public static void main(String[] args) {
        FruitStorage.fruitsStorage.put("apple", APPLE_QUANTITY);
        FruitStorage.fruitsStorage.put("banana", BANANA_QUANTITY);
        FruitStorage.fruitsStorage.put("orange", ORANGE_QUANTITY);

        Map<String, OperationHandler> operationHandlersMap = new HashMap<>();

        operationHandlersMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationHandler());
        operationHandlersMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationHandler());
        operationHandlersMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationHandler());
        operationHandlersMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationHandler());

        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationHandlersMap);

        TransactionParseService transactionParseService = new TransactionParseServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);

        ReadFromFileService readFromFileService =
                new ReadFromFileServiceImpl();
        WriteToFileService writeToFileService =
                new WriteToFileServiceImpl();
        CreateReportService createReportService =
                new CreateReportServiceImpl();

        String dataFromFile = readFromFileService.readFromFile(START_FILE_PATH);
        fruitShopService.processOfOperations(transactionParseService.parseList(dataFromFile));
        String report = createReportService.createReport();
        writeToFileService.writeToFile(report, RESULT_FILE_PATH);
    }
}
