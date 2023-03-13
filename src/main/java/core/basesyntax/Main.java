package core.basesyntax;

import dao.FruitDaoCsvImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitStore;
import service.FruitStoreService;
import service.impl.FruitStoreServiceImpl;
import strategy.ActivitiesStrategyImpl;
import strategy.activities.ActivitiesHandler;
import strategy.activities.BalanceHandler;
import strategy.activities.PurchaseHandler;
import strategy.activities.ReturnHandler;
import strategy.activities.SupplyHandler;

public class Main {
    private static Map<String, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
    private static FruitStoreService fruitStoreService = new FruitStoreServiceImpl(
            new FruitDaoCsvImpl("./src/main/resources/database.csv",
                    "./src/main/resources/report.csv"),
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
