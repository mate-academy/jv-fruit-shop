package core.basesyntax;

import core.basesyntax.dao.InputFileDao;
import core.basesyntax.dao.InputFileDaoImpl;
import core.basesyntax.service.DataService;
import core.basesyntax.service.DataServiceImpl;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.StoreServiceImpl;
import core.basesyntax.service.activities.ActivitiesHandler;
import core.basesyntax.service.activities.BalanceActivitiesHandler;
import core.basesyntax.service.activities.PurchaseActivitiesHandler;
import core.basesyntax.service.activities.ReturnActivitiesHandler;
import core.basesyntax.service.activities.SupplyActivitiesHandler;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put("b", new BalanceActivitiesHandler());
        activitiesHandlerMap.put("p", new PurchaseActivitiesHandler());
        activitiesHandlerMap.put("r", new ReturnActivitiesHandler());
        activitiesHandlerMap.put("s", new SupplyActivitiesHandler());

        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activitiesHandlerMap);
        InputFileDao inputFileDao = new InputFileDaoImpl();
        DataService dataService = new DataServiceImpl(inputFileDao);
        dataService.registerDataFromFile("storeInputData.csv");
        StoreService store = new StoreServiceImpl(inputFileDao, activityStrategy);
        store.createReportFile("src/main/resources/reportStoreInputData.csv",
                "storeInputData.csv");
    }
}
