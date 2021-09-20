package core.basesyntax;

import core.basesyntax.service.FruitsShopService;
import core.basesyntax.service.FruitsShopServiceImpl;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.service.activity.BalanceHandler;
import core.basesyntax.service.activity.PurchaseHandler;
import core.basesyntax.service.activity.ReturnHandler;
import core.basesyntax.service.activity.SupplyHandler;
import core.basesyntax.service.minorservices.ReaderServiceImpl;
import core.basesyntax.service.minorservices.WriterServiceImpl;
import core.basesyntax.service.strategy.ActivityStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put("b", new BalanceHandler());
        activityHandlerMap.put("p", new PurchaseHandler());
        activityHandlerMap.put("s", new SupplyHandler());
        activityHandlerMap.put("r", new ReturnHandler());
        FruitsShopService fruitsShopService =
                new FruitsShopServiceImpl(new ActivityStrategyImpl(activityHandlerMap),
                        new ReaderServiceImpl(), new WriterServiceImpl());
        String report = fruitsShopService.createReport("src/main/resources/activities.csv");
        System.out.println(report);
    }
}
