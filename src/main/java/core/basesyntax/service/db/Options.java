package core.basesyntax.service.db;

import core.basesyntax.service.operation.BalanceFruitService;
import core.basesyntax.service.operation.FruitService;
import core.basesyntax.service.operation.PurchaseFruitService;
import core.basesyntax.service.operation.ReturnFruitService;
import core.basesyntax.service.operation.SupplyFruitService;
import java.util.HashMap;
import java.util.Map;

public class Options {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String PURCHASE = "p";
    public static final String RETURN = "r";
    private Map<String, FruitService> handlerMap = new HashMap<>();

    public Map<String, FruitService> getHandlerMap() {
        return handlerMap;
    }

    public void initialHandler() {

        handlerMap.put(BALANCE, new BalanceFruitService());
        handlerMap.put(SUPPLY, new SupplyFruitService());
        handlerMap.put(PURCHASE, new PurchaseFruitService());
        handlerMap.put(RETURN, new ReturnFruitService());
    }
}
