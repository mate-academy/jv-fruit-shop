package core.basesyntax.factory.impl;

import core.basesyntax.factory.Factory;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.BalanceStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseStrategyImpl;
import core.basesyntax.strategy.impl.ReturnStrategyImpl;
import core.basesyntax.strategy.impl.SupplyStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class FactoryImpl implements Factory {
    private final Map<Operation, Strategy> strategies = new HashMap<>();

    public FactoryImpl() {
        strategies.put(Operation.BALANCE, new BalanceStrategyImpl());
        strategies.put(Operation.RETURN, new ReturnStrategyImpl());
        strategies.put(Operation.PURCHASE, new PurchaseStrategyImpl());
        strategies.put(Operation.SUPPLY, new SupplyStrategyImpl());
    }

    @Override
    public Strategy getStrategy(Operation operation) {
        for (Map.Entry<Operation, Strategy> strategy : strategies.entrySet()) {
            if (strategy.getKey().equals(operation)) {
                return strategy.getValue();
            }
        }
        throw new RuntimeException("Unknown operation" + operation);
    }
}
