package core.basesyntax;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.dao.impl.FruitRepositoryImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.OperationStrategy;
import core.basesyntax.service.handler.impl.BalanceOperationHandler;
import core.basesyntax.service.handler.impl.OperationStrategyImpl;
import core.basesyntax.service.handler.impl.PurchaseOperationHandler;
import core.basesyntax.service.handler.impl.ReturnOperationHandler;
import core.basesyntax.service.handler.impl.SupplyOperationHandler;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileService fileService = new FileServiceImpl();
        List<String> inputReport = fileService.read("transactions.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();

        // 3. Create and feel the map with all OperationHandler implementations
        FruitRepository repository = new FruitRepositoryImpl();
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandler(repository));
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler(repository));
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandler(repository));
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandler(repository));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations

        List<FruitTransaction> transactions = dataConverter
                .convertToFruitTransactions(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl(repository);
        String resultingReport = reportGenerator.generateReport();

        // 6. Write the received report into the destination file
        fileService.write("report.csv", resultingReport);
    }
}
