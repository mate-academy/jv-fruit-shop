package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvFormatReportGenerator;
import core.basesyntax.service.impl.DataConverterServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.operation.BalanceOperation;
import core.basesyntax.service.impl.operation.OperationHandler;
import core.basesyntax.service.impl.operation.PurchaseOperation;
import core.basesyntax.service.impl.operation.ReturnOperation;
import core.basesyntax.service.impl.operation.SupplyOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final FruitStorageDao FRUIT_STORAGE_DAO = new FruitStorageDaoImpl();

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> inputReport = fileReader.read("src/main/resources/reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverterService dataConverter = new DataConverterServiceImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        System.out.println(transactions);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(FRUIT_STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(FRUIT_STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(FRUIT_STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(FRUIT_STORAGE_DAO));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new CsvFormatReportGenerator(FRUIT_STORAGE_DAO);
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(resultingReport, "src/main/resources/finalReport.csv");
    }
}
