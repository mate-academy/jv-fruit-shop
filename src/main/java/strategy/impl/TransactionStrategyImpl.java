package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.GeneralOperation;
import strategy.TransactionStrategy;

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
