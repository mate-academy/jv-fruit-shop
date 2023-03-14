package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationsMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }
    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return operationsMap.get(type);
    }
}
