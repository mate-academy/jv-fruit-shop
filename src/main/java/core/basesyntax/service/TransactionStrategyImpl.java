package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.HashMap;

public class TransactionStrategyImpl implements TransactionStrategy {
    private HashMap<FruitTransaction.Operation, TransactionHandler> operationMap;

    public TransactionStrategyImpl(
            HashMap<FruitTransaction.Operation, TransactionHandler> operationMap
    ) {
        this.operationMap = operationMap;
    }

    @Override
    public TransactionHandler getHandler(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
