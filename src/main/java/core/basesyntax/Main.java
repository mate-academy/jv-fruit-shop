package core.basesyntax;

import core.basesyntax.db.DataConverter;
import core.basesyntax.db.DataConverterImpl;
import core.basesyntax.db.FileReaderImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operations.BalanceOperation;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperation;
import core.basesyntax.service.operations.ReturnOperation;
import core.basesyntax.service.operations.SupplyOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Read the data from the input CSV file
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("input.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        transactions.stream()
                .forEach(System.out::println);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        for (String name: Storage.fruits.keySet()) {
            String key = name.toString();
            String value = Storage.fruits.get(name).toString();
            System.out.println(key + " " + value);
        }

        /*
        TODO
        5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
        */
    }
}
