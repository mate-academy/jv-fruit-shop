package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionHandlerStrategy;
import java.util.Map;

public class TransactionHandlerStrategyImp implements TransactionHandlerStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> operationMap;

    public TransactionHandlerStrategyImp(Map<FruitTransaction.Operation,
            TransactionHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
