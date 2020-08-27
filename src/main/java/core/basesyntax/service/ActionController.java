package core.basesyntax.service;

import core.basesyntax.Transaction;
import core.basesyntax.service.impl.BuyAction;
import core.basesyntax.service.impl.ReturnAction;
import core.basesyntax.service.impl.SupplyAction;
import java.util.HashMap;
import java.util.Map;

public class ActionController {
    private static final Map<String, ActionsWithFruits> actions = new HashMap<>();

    static {
        actions.put("s", new SupplyAction());
        actions.put("b", new BuyAction());
        actions.put("r", new ReturnAction());
    }

    public void distributeActions(Transaction transaction) {
        ActionsWithFruits action = actions.get(transaction.getAction());
        action.applyAction(transaction);
    }
}
