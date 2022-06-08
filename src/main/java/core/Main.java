package core;

import core.dao.FruitDaoImpl;
import core.service.CsvReaderService;
import core.service.CsvWriterService;
import core.service.FruitService;
import core.service.FruitTransactionProcessorService;
import core.service.ReportCreatorService;
import core.service.impl.CsvReaderServiceImpl;
import core.service.impl.CsvWriterServiceImpl;
import core.service.impl.FruitServiceImpl;
import core.service.impl.FruitTransactionProcessorServiceImpl;
import core.service.impl.ReportCreatorServiceImpl;
import core.strategy.OperationHandlerStrategy;
import core.strategy.OperationHandlerStrategyImpl;
import core.strategy.handlers.BalanceHandler;
import core.strategy.handlers.OperationHandler;
import core.strategy.handlers.PurchaseHandler;
import core.strategy.handlers.ReturnHandler;
import core.strategy.handlers.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FRUITS_FILE_NAME = "fruits.csv";
    private static final String REPORT_FILE_NAME = "report.csv";
    private static FruitService fruitService = new FruitServiceImpl(new FruitDaoImpl());

    public static void main(String[] args) {
        CsvReaderService csvReaderService = new CsvReaderServiceImpl();
        List<String> fruitsOperations = csvReaderService.readFromFile(FRUITS_FILE_NAME);

        Map<String, OperationHandler> operationsHandlerMap = initOperationsHandlerMap();
        OperationHandlerStrategy operationHandlerStrategy =
                new OperationHandlerStrategyImpl(operationsHandlerMap);

        FruitTransactionProcessorService fruitTransactionProcessorService =
                new FruitTransactionProcessorServiceImpl(operationHandlerStrategy);
        fruitTransactionProcessorService.fillStorage(fruitsOperations);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl(fruitService);
        String report = reportCreatorService.createReport();

        CsvWriterService csvWriterService = new CsvWriterServiceImpl();
        csvWriterService.write(REPORT_FILE_NAME,report);
    }

    private static Map<String, OperationHandler> initOperationsHandlerMap() {
        Map<String, OperationHandler> operationsHandlerMap = new HashMap<>();
        operationsHandlerMap.put("b", new BalanceHandler(fruitService));
        operationsHandlerMap.put("s", new SupplyHandler(fruitService));
        operationsHandlerMap.put("r", new ReturnHandler(fruitService));
        operationsHandlerMap.put("p", new PurchaseHandler(fruitService));
        return operationsHandlerMap;
    }
}
