package core.basesyntax;

import converter.DataConverterImpl;
import handler.BalanceOperationHandler;
import handler.OperationHandler;
import handler.PurchaseOperationHandler;
import handler.ReturnOperationHandler;
import handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import read.write.file.FileReaderImpl;
import read.write.file.FileWriterImpl;
import report.ReportGeneratorImpl;
import service.ShopServiceImpl;
import strategy.OperationStrategyImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        DataConverterImpl dataConverter = new DataConverterImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        Map<String, Integer> storage = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storage));
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl(storage);
        FileWriterImpl fileWriter = new FileWriterImpl();

        String inputFilePath = "src/reportToRead.csv";
        String outputFilePath = "finalReport.csv";

        FruitShopManager fruitShopManager = new FruitShopManager(fileReader,
                dataConverter, shopService,
                reportGenerator, fileWriter,
                inputFilePath, outputFilePath);
        fruitShopManager.manageShop();
    }
}
