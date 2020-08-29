package core.basesyntax.service;

import core.basesyntax.Transaction;
import core.basesyntax.service.impl.BuyAction;
import core.basesyntax.service.impl.ReturnAction;
import core.basesyntax.service.impl.SupplyAction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionController {
    private static final Map<String, FruitAction> actions = new HashMap<>();

    static {
        actions.put("s", new SupplyAction());
        actions.put("b", new BuyAction());
        actions.put("r", new ReturnAction());
    }

    public void distributeActions(List<Transaction> data) {
        for (Transaction item : data) {
            FruitAction action = actions.get(item.getAction());
            action.applyAction(item);
        }
    }
}
