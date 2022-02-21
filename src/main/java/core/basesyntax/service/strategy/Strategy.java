package core.basesyntax.service.strategy;

import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private static Map<String, OperationAtFruit> strategy = new HashMap();

    {
        strategy.put("b", new BalanceOperation());
        strategy.put("s", new SupplyOperations());
        strategy.put("r", new ReturnOperations());
        strategy.put("p", new PurchaseOperation());
    }

    public OperationAtFruit getOperationHendler(String operation) {
        return strategy.get(operation);
    }
}
