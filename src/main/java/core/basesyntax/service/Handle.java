package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import java.util.HashMap;

public class HandleCheck {
    private static final HashMap<String, Handleable> handleCheck = new HashMap<>();

    static {
        handleCheck.put("s", new SupplyService());
        handleCheck.put("b", new BuyService());
        handleCheck.put("r", new ReturnService());
    }

    public void operationWithProduct(String action, Fruit fruit) {
        Handleable handleAble = handleCheck.get(action);
        handleAble.operationWithProduct(fruit);
    }
}
