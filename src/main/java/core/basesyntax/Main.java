package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.io.FileReader;
import core.basesyntax.service.io.FileReaderImpl;
import core.basesyntax.service.io.FileWriter;
import core.basesyntax.service.io.FileWriterImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.handler.OperationHandler;
import core.basesyntax.service.strategy.handler.impl.BalanceOperation;
import core.basesyntax.service.strategy.handler.impl.PurchaseOperation;
import core.basesyntax.service.strategy.handler.impl.ReturnOperation;
import core.basesyntax.service.strategy.handler.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_DATA_FILE_PATH = "src/main/resources/inputData.csv";
    public static final String REPOT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl(INPUT_DATA_FILE_PATH);
        List<String> inputReport = fileReader.read();

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        Storage storage = new Storage();

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(storage);

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, REPOT_FILE_PATH);
    }
}
