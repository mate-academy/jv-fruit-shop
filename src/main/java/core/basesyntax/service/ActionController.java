package core.basesyntax.service;

import core.basesyntax.Transaction;
import core.basesyntax.service.impl.BuyAction;
import core.basesyntax.service.impl.ReturnAction;
import core.basesyntax.service.impl.SupplyAction;
import java.util.HashMap;
import java.util.Map;

public class ActionController {
    private static final Map<String, ActionsWithFruits> transfer = new HashMap<>();

    static {
        transfer.put("s", new SupplyAction());
        transfer.put("b", new BuyAction());
        transfer.put("r", new ReturnAction());
    }

    public void distributeActions(Transaction transaction) {
        ActionsWithFruits action = transfer.get(transaction.getAction());
        action.applyAction(transaction);
    }
}
