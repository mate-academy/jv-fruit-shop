package core.basesyntax.shop.implementation;

import core.basesyntax.handlers.Activity;
import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHandler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.shop.Activities;
import java.util.HashMap;
import java.util.Map;

public class HandlerMap {
    private Map<String, Activity> activitieMap;

    public HandlerMap() {
        activitieMap = new HashMap<>();
    }

    public Map<String, Activity> getHandlerMap() {
        activitieMap.put(Activities.BALANCE.getType(), new BalanceHandler());
        activitieMap.put(Activities.SUPPLY.getType(), new SupplyHandler());
        activitieMap.put(Activities.PURCHASE.getType(), new PurchaseHandler());
        activitieMap.put(Activities.RETURN.getType(), new ReturnHandler());
        return activitieMap;
    }
}
