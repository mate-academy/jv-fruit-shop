package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandlers;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandlers;
import core.basesyntax.strategy.handlers.ReturnOperationHandlers;
import core.basesyntax.strategy.handlers.SupplyOperationHandlers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String IMPORT_FILE_NAME = "reportToRead.csv";
    public static final String EXPORT_FILE_NAME = "finalReport.csv";

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(IMPORT_FILE_NAME);

        // 2. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlers());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlers());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlers());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlers());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 3. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.generateReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, EXPORT_FILE_NAME);
    }
}
