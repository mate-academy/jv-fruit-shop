package core.basesyntax.shop.implementation;

import core.basesyntax.handlers.Activitie;
import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHundler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.shop.Activities;
import java.util.HashMap;
import java.util.Map;

public class HandlerMap {
    private Map<String, Activitie> activitieMap;

    public HandlerMap() {
        activitieMap = new HashMap<>();
    }

    public Map<String,Activitie> getHandlerMap() {
        activitieMap.put(Activities.BALANCE.getType(), new BalanceHandler());
        activitieMap.put(Activities.SUPPLY.getType(), new SupplyHandler());
        activitieMap.put(Activities.PURCHASE.getType(), new PurchaseHandler());
        activitieMap.put(Activities.RETURN.getType(), new ReturnHundler());
        return activitieMap;
    }
}
