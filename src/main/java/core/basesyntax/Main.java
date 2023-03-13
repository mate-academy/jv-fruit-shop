package core.basesyntax;

import dao.FruitDaoCsvImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitStore;
import service.ActivitiesStrategyImpl;
import service.FruitStoreService;
import service.FruitStoreServiceImpl;
import service.activities.ActivitiesHandler;
import service.activities.BalanceHandler;
import service.activities.PurchaseHandler;
import service.activities.ReturnHandler;
import service.activities.SupplyHandler;

public class Main {
    private static Map<String, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
    private static FruitStoreService fruitStoreService = new FruitStoreServiceImpl(
            new FruitDaoCsvImpl("database.csv", "report.csv"),
            new ActivitiesStrategyImpl(activitiesHandlerMap),
            new FruitStore());

    public static void main(String[] args) {
        activitiesHandlerMap.put("b", new BalanceHandler());
        activitiesHandlerMap.put("s", new SupplyHandler());
        activitiesHandlerMap.put("p", new PurchaseHandler());
        activitiesHandlerMap.put("r", new ReturnHandler());

        fruitStoreService.processInputData();
        fruitStoreService.generateReport();
    }
}
