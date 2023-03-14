package core.basesyntax;

import dao.impl.ReaderServiceImpl;
import dao.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.Map;
import service.CreateReportService;
import service.ProcessData;
import service.impl.CreateReportServiceImpl;
import service.impl.ProcessDataImpl;
import strategy.ActivitiesStrategyImpl;
import strategy.activities.ActivitiesHandler;
import strategy.activities.BalanceHandler;
import strategy.activities.PurchaseHandler;
import strategy.activities.ReturnHandler;
import strategy.activities.SupplyHandler;

public class Main {
    private static Map<String, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();

    private static CreateReportService createReportService = new CreateReportServiceImpl(
            new WriterServiceImpl("./src/main/resources/report.csv"));

    private static ProcessData processData = new ProcessDataImpl(
            new ReaderServiceImpl("./src/main/resources/database.csv"),
            new ActivitiesStrategyImpl(activitiesHandlerMap));

    public static void main(String[] args) {
        activitiesHandlerMap.put("b", new BalanceHandler());
        activitiesHandlerMap.put("s", new SupplyHandler());
        activitiesHandlerMap.put("p", new PurchaseHandler());
        activitiesHandlerMap.put("r", new ReturnHandler());

        processData.processInputData();
        createReportService.generateReport();
    }
}
