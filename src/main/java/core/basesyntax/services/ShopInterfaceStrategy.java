package core.basesyntax.services;

import core.basesyntax.Storage;
import core.basesyntax.services.impl.Buy;
import core.basesyntax.services.impl.SupplyAndReturn;
import java.util.HashMap;
import java.util.Map;

public class ShopInterfaceStrategy {
    private static final String ACTION_BUY = "b";
    private static final String ACTION_SUPPLY = "s";
    private static final String ACTION_RETURN = "r";
    private final Map<String, ActionInterface> interfaceMap;

    public ShopInterfaceStrategy(Storage storage) {
        interfaceMap = new HashMap<>();
        interfaceMap.put(ACTION_BUY, new Buy(storage));
        interfaceMap.put(ACTION_SUPPLY, new SupplyAndReturn(storage));
        interfaceMap.put(ACTION_RETURN, new SupplyAndReturn(storage));
    }

    public ActionInterface get(String strategy) {
        if (interfaceMap.containsKey(strategy)) {
            return interfaceMap.get(strategy);
        }
        return null;
    }
}
