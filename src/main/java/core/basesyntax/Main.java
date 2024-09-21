package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import core.basesyntax.operations.OperationStrategyImpl;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.FruitShopApplication;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = args.length > 0 ? args[0] : System.getenv("DEFAULT_INPUT_FILE_PATH");
        String outputFilePath = args.length > 1 ? args[1]
                : System.getenv("DEFAULT_OUTPUT_FILE_PATH");

        Storage storage = new Storage();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storage));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);

        FruitShopApplication fruitShopApp = new FruitShopApplication(
                new FileReaderImpl(),
                new DataConverterImpl(),
                shopService,
                new ReportGeneratorImpl(),
                new FileWriterImpl()
        );

        try {
            fruitShopApp.run(inputFilePath, outputFilePath);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error occurred while running the application: "
                    + e.getMessage(), e);
        }
    }
}

