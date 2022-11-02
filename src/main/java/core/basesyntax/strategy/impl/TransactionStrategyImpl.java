package core.basesyntax.strategy.impl;

import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> strategyMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return strategyMap.get(operation);
    }
}
