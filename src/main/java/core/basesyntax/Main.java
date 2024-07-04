package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperation;
import core.basesyntax.strategy.operation.FruitOperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String REPORT = "src/main/resources/report.csv";
    private static final String FINAL_REPORT = "src/main/resources/final-report.csv";
    private static final StorageDao STORAGE_DAO = new StorageDaoImpl();

    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.getDataFromFile(REPORT);

        Map<FruitTransaction.Operation, FruitOperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(STORAGE_DAO));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransactions(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String finalReport = reportGenerator.getReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(finalReport, FINAL_REPORT);
    }
}
