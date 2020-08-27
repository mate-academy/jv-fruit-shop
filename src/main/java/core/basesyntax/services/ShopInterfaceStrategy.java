package core.basesyntax.services;

import core.basesyntax.services.impl.Buy;
import core.basesyntax.services.impl.SupplyAndReturn;
import java.util.HashMap;
import java.util.Map;

public class ShopInterfaceStrategy {
    private static final String ACTION_BUY = "b";
    private static final String ACTION_SUPPLY = "s";
    private static final String ACTION_RETURN = "r";
    private final Map<String, ActionInterface> interfaceMap;

    public ShopInterfaceStrategy() {
        interfaceMap = new HashMap<>();
        interfaceMap.put(ACTION_BUY, new Buy());
        interfaceMap.put(ACTION_SUPPLY, new SupplyAndReturn());
        interfaceMap.put(ACTION_RETURN, new SupplyAndReturn());
    }

    public ActionInterface get(String strategy) {
        if (interfaceMap.containsKey(strategy)) {
            return interfaceMap.get(strategy);
        }
        return null;
    }
}
