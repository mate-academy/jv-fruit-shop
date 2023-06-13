package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransactionParseService;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParseServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/inputFile.csv";
    private static final String OUTPUT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/outputFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileService fileService = new FileServiceImpl();
        FruitTransactionParseService fruitTransactionParseService =
                new FruitTransactionParseServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);

        List<String> records = fileService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions =
                fruitTransactionParseService.parseFruitTransaction(records);

        String report = fruitShopService.applyTransactions(transactions);
        fileService.writeToFile(OUTPUT_FILE_PATH, report);

    }
}
