package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;
import core.basesyntax.model.operation.BalanceOperation;
import core.basesyntax.model.operation.PurchaseOperation;
import core.basesyntax.model.operation.ReturnOperation;
import core.basesyntax.model.operation.SupplyOperation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvDataConverterImpl;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILES_PATH = "src/main/resources/";
    private static final String INPUT_FILE_NAME = "input.csv";
    private static final String OUTPUT_FILE_NAME = "output.csv";
    private static final String INPUT_FILE_PATH = FILES_PATH + INPUT_FILE_NAME;
    private static final String OUTPUT_FILE_PATH = FILES_PATH + OUTPUT_FILE_NAME;

    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new CsvFileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);

        // 3. Create a storage for managing how many products quantity available
        Storage storage = new Storage();

        // 4. Create and fill the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new CsvDataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 5. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 6. Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        // 7. Write the received report into the destination file
        FileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_PATH);
    }
}
