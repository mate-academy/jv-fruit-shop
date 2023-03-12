package core.basesyntax;

import core.basesyntax.model.Activity;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ActivityService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ActivityServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        //Map for strategy pattern
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandlerImpl());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandlerImpl());

        //Read data from file
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromCsv =
                readerService.getDataFromCsv(INPUT_FILE_PATH);

        //Convert data to Activity objects and collect them to list
        ActivityService activityService = new ActivityServiceImpl();
        List<Activity> activitiesFromData =
                activityService.getActivitiesFromInput(dataFromCsv);

        //Process all activity object in list by strategy pattern
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        activitiesFromData
                .forEach(a -> operationStrategy.getHandler(a.getOperation()).process(a));

        //Create report using date from storage
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(reportService.getDataForReport());

        //Save report to destination file;
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToCsv(OUTPUT_FILE_PATH, report);
    }
}
