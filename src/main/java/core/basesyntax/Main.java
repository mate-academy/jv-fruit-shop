package core.basesyntax;

import core.db.Storage;
import core.db.impl.StorageImpl;
import core.io.FileReaderImpl;
import core.io.FileWriterImpl;
import core.service.DataConverter;
import core.service.ReportGenerator;
import core.service.ShopService;
import core.service.impl.DataConverterImpl;
import core.service.impl.ReportGeneratorImpl;
import core.service.impl.ShopServiceImpl;
import core.strategy.FruitTransaction;
import core.strategy.OperationHandler;
import core.strategy.OperationStrategy;
import core.strategy.impl.BalanceOperation;
import core.strategy.impl.OperationStrategyImpl;
import core.strategy.impl.PurchaseOperation;
import core.strategy.impl.ReturnOperation;
import core.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Створюємо об'єкт твого класу
        FileReaderImpl fileReader = new FileReaderImpl();
        // 2. Викликаємо метод (він має повертати List<String>)
        List<String> inputReport = fileReader.read("/reportToRead.csv");
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        Storage storage = new StorageImpl();
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);
        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();
        // 6. Write the received report into the destination file
        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.write("finalReport.csv", resultingReport);
    }
}
