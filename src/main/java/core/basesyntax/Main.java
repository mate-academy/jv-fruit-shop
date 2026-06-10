package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvDataConverterImpl;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.CsvReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String RECOURSES_PATH = "src/main/resources/";
    private static final String FILE_TO_READ = RECOURSES_PATH + "reportToRead.csv";
    private static final String FILE_TO_WRITE = RECOURSES_PATH + "finalReport.csv";

    public static void main(String[] arg) {
        FileReader fileReader = new CsvFileReaderImpl();
        List<String> inputReport = fileReader.readAllLines(FILE_TO_READ);

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new CsvDataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransactionList(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers =
                getOperationHandlersMap(storageDao);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new CsvReportGeneratorImpl(storageDao);
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.write(FILE_TO_WRITE, resultingReport);
    }

    private static Map<FruitTransaction.Operation, OperationHandler>
                    getOperationHandlersMap(StorageDao storageDao) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageDao));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));

        return operationHandlers;
    }
}
