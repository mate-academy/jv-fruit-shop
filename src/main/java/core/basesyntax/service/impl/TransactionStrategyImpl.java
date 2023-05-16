package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.strategy.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> activitiesHandlersMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> activitiesHandlersMap) {
        this.activitiesHandlersMap = activitiesHandlersMap;
    }

    @Override
    public TransactionHandler getHandler(FruitTransaction.Operation operation) {
        return activitiesHandlersMap.get(operation);
    }
}
