package core.basesyntax.service.strategy;

import java.util.HashMap;
import java.util.Map;

public class Options {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String PURCHASE = "p";
    public static final String RETURN = "r";
    private Map<String, FruitHandler> handlerMap = new HashMap<>();

    public Map<String, FruitHandler> getHandlerMap() {
        return handlerMap;
    }

    public void initialHandler() {

        handlerMap.put(BALANCE, new BalanceFruitHandler());
        handlerMap.put(SUPPLY, new SupplyFruitHandler());
        handlerMap.put(PURCHASE, new PurchaseFruitHandler());
        handlerMap.put(RETURN, new ReturnFruitHandler());
    }
}
