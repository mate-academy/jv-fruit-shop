package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationsHandler;
import core.basesyntax.strategy.impl.BalanceOperationsHandler;
import core.basesyntax.strategy.impl.PurchaseOperationsHandler;
import core.basesyntax.strategy.impl.ReturnOperationsHandler;
import core.basesyntax.strategy.impl.SupplyOperationsHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT = "src/main/resources/report.csv";
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_SORT = 1;
    private static final int INDEX_OF_OPERATIONS_AMOUNT = 2;

    public static void main(String[] args) {
        Map<OperationType, OperationsHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(OperationType.BALANCE, new BalanceOperationsHandler());
        operationStrategies.put(OperationType.SUPPLY, new SupplyOperationsHandler());
        operationStrategies.put(OperationType.PURCHASE, new PurchaseOperationsHandler());
        operationStrategies.put(OperationType.RETURN, new ReturnOperationsHandler());

        FruitService strategies = new FruitServiceImpl(operationStrategies);
        ReaderService readService = new ReaderServiceImpl();
        DataProcessingService processingService =
                new DataProcessingServiceImpl(strategies,
                                              INDEX_OF_OPERATION_TYPE,
                                              INDEX_OF_FRUIT_SORT,
                                              INDEX_OF_OPERATIONS_AMOUNT);
        ReportCreatorService reportService = new ReportCreatorServiceImpl();
        WriterService writeService = new WriterServiceImpl();

        List<String> list = readService.readFromFile(PATH_TO_INPUT_FILE);
        processingService.processing(list);
        String report = reportService.createReport();
        writeService.writeToFile(report, PATH_TO_REPORT);
    }
}
