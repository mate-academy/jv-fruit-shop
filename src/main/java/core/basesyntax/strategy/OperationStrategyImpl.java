package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReturnHandler;
import core.basesyntax.strategy.handlers.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> map = new HashMap<>();

    {
        map.put(Operation.BALANCE, new BalanceHandler());
        map.put(Operation.SUPPLY, new SupplyHandler());
        map.put(Operation.PURCHASE, new PurchaseHandler());
        map.put(Operation.RETURN, new ReturnHandler());
    }

    @Override
    public OperationHandler get(Operation operation) {
        return map.get(operation);
    }
}
