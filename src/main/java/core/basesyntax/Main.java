package core.basesyntax;

import dao.FruitDaoCsvImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitStore;
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
    private static FruitStore fruitStore = new FruitStore();

    private static CreateReportService createReportService = new CreateReportServiceImpl(
            new FruitDaoCsvImpl("./src/main/resources/report.csv"),
            fruitStore);

    private static ProcessData processData = new ProcessDataImpl(
            new FruitDaoCsvImpl("./src/main/resources/database.csv"),
            new ActivitiesStrategyImpl(activitiesHandlerMap),
            fruitStore);

    public static void main(String[] args) {
        activitiesHandlerMap.put("b", new BalanceHandler());
        activitiesHandlerMap.put("s", new SupplyHandler());
        activitiesHandlerMap.put("p", new PurchaseHandler());
        activitiesHandlerMap.put("r", new ReturnHandler());

        processData.processInputData();
        createReportService.generateReport();
    }
}
