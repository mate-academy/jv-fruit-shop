package core.basesyntax.strategy.impl;

import core.basesyntax.service.FruitTransaction.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation,
            OperationHandler> strategiesMap = new HashMap<>();

    {
        strategiesMap.put(Operation.BALANCE, new BalanceOperationHandler());
        strategiesMap.put(Operation.RETURN, new ReturnOperationHandler());
        strategiesMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        strategiesMap.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    @Override
    public OperationHandler getStrategy(Operation operation) {
        return strategiesMap.get(operation);
    }
}
