package core.basesyntax;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceOperation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.FileRead;
import core.basesyntax.service.FileReadImpl;
import core.basesyntax.service.FileWrite;
import core.basesyntax.service.FileWriteImpl;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.PurchaseOperation;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ReturnOperation;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.SupplyOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] arg) {
        // Create an inventory instance
        Inventory inventory = new Inventory();

        // 1. Read the data from the input CSV file
        FileRead fileRead = new FileReadImpl();
        List<String> inputReport = fileRead.readDataFromFile("reportToRead.csv");

        // 2. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, FruitOperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 3. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy, inventory);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(inventory);

        // 6. Write the received report into the destination file
        FileWrite fileWriter = new FileWriteImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
