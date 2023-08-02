package core.basesyntax.service;

import core.basesyntax.model.Activity;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.service.activity.BalanceHandler;
import core.basesyntax.service.activity.PurchaseHandler;
import core.basesyntax.service.activity.ReturnHandler;
import core.basesyntax.service.activity.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class ActivityStrategy {

    private final Map<Activity.Type, ActivityHandler> activitiesHandlerMap;

    public ActivityStrategy() {
        activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(Activity.Type.BALANCE, new BalanceHandler());
        activitiesHandlerMap.put(Activity.Type.SUPPLY, new SupplyHandler());
        activitiesHandlerMap.put(Activity.Type.PURCHASE, new PurchaseHandler());
        activitiesHandlerMap.put(Activity.Type.RETURN, new ReturnHandler());

    }

    public ActivityHandler get(Activity.Type type) {
        return activitiesHandlerMap.get(type);
    }
}
