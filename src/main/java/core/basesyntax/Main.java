package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ProductDaoCsvImpl;
import core.basesyntax.service.Converter;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.ConverterImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReportGenerator;
import core.basesyntax.strategy.ReportGeneratorImpl;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "product-data.csv";
    private static final String DESTINATION_FILE = "result.csv";

    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        Storage storage = new Storage();
        ProductDaoCsvImpl dao = new ProductDaoCsvImpl(SOURCE_FILE);

        // 2. Convert the incoming data into FruitTransactions list
        List<String> res = dao.getAll();
        Converter converter = new ConverterImpl(dao);
        List<FruitTransaction> transactions = converter.convertToTransaction(res);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(storage);

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, DESTINATION_FILE);
    }
}
