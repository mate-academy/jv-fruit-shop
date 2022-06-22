package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataOperationService;
import core.basesyntax.service.DataService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.impl.DataOperationServiceImpl;
import core.basesyntax.service.impl.DataServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGenerationServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String DAILY_ACTIVITIES_PATH = "src/main/resources/dailyActivities.csv";
    private static final String DAILY_REPORT_PATH = "src/main/resources/dailyReport.csv";

    public static void main(String[] arg) {
        StorageDao storageDao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FileReaderService readerService = new FileReaderServiceImpl();
        List<String> activities = readerService.readFromFile(DAILY_ACTIVITIES_PATH);

        DataService dataService = new DataServiceImpl();
        List<FruitTransaction> fruitTransactionList = dataService.processData(activities);

        DataOperationService dataOperationService = new DataOperationServiceImpl(operationStrategy);
        dataOperationService.processOperation(fruitTransactionList);

        ReportGenerationService reportGeneration = new ReportGenerationServiceImpl(storageDao);
        String report = reportGeneration.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(DAILY_REPORT_PATH, report);
    }
}
