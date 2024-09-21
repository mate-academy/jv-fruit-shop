package core.basesyntax;

import core.basesyntax.application.FruitShopApplication;
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
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.services.DataConverterImpl;
import core.basesyntax.services.FileReaderImpl;
import core.basesyntax.services.FileWriterImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String DEFAULT_INPUT_FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String DEFAULT_OUTPUT_FILE_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        String inputFilePath = args.length > 0 ? args[0] : DEFAULT_INPUT_FILE_PATH;
        String outputFilePath = args.length > 1 ? args[1] : DEFAULT_OUTPUT_FILE_PATH;

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);

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
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

