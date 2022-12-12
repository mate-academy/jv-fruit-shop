package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.GeneralOperation;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, GeneralOperation> operationHandlersMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            GeneralOperation> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public GeneralOperation get(FruitTransaction.Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
