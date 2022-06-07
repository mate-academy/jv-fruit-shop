package core;

import core.service.CreateReportService;
import core.service.ReadCsvService;
import core.service.StorageFillingService;
import core.service.UpdateFruitsStrategy;
import core.service.UpdateFruitsStrategyImpl;
import core.service.handlers.BalanceHandler;
import core.service.handlers.FruitOperationHandler;
import core.service.handlers.PurchaseHandler;
import core.service.handlers.ReturnHandler;
import core.service.handlers.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FRUITS_FILE_NAME = "fruits.csv";
    private static final String REPORT_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        ReadCsvService readCsvService = new ReadCsvService();
        List<String> fruitsOperations = readCsvService.getFruitOperations(FRUITS_FILE_NAME);

        Map<String, FruitOperationHandler> operationsHandlerMap = initOperationsHandlerMap();
        UpdateFruitsStrategy updateFruitsStrategy =
                new UpdateFruitsStrategyImpl(operationsHandlerMap);

        StorageFillingService storageFillingService =
                new StorageFillingService(updateFruitsStrategy);
        storageFillingService.fillStorage(fruitsOperations);

        CreateReportService createReportService = new CreateReportService();
        createReportService.createReport(REPORT_FILE_NAME);
    }

    private static Map<String, FruitOperationHandler> initOperationsHandlerMap() {
        Map<String, FruitOperationHandler> operationsHandlerMap = new HashMap<>();
        operationsHandlerMap.put("b", new BalanceHandler());
        operationsHandlerMap.put("s", new SupplyHandler());
        operationsHandlerMap.put("r", new ReturnHandler());
        operationsHandlerMap.put("p", new PurchaseHandler());
        return operationsHandlerMap;
    }
}
