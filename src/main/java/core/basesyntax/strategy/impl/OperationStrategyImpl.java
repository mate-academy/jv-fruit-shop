package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationProcessor> operationProcessMap;

    public OperationStrategyImpl(Map<Transaction.Operation,
            OperationProcessor> operationProcessMap) {
        this.operationProcessMap = operationProcessMap;
    }

    @Override
    public OperationProcessor get(Transaction.Operation fruitOperation) {
        return operationProcessMap.get(fruitOperation);
    }
}
