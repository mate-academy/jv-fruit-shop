package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> operationMap;

    public TransactionStrategyImpl(
            Map<FruitTransaction.Operation, TransactionHandler> operationMap
    ) {
        this.operationMap = operationMap;
    }

    @Override
    public TransactionHandler getHandler(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
