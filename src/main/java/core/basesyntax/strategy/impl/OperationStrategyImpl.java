package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationProcessor> operationProcessMap;

    public OperationStrategyImpl() {
        this.operationProcessMap = new HashMap<>();
        operationProcessMap.put(Operation.BALANCE,
                new QuantityAddOperationProcessor());
        operationProcessMap.put(Operation.SUPPLY,
                new QuantityAddOperationProcessor());
        operationProcessMap.put(Operation.PURCHASE,
                new PurchaseOperationProcessor());
        operationProcessMap.put(Operation.RETURN,
                new QuantityAddOperationProcessor());
    }

    @Override
    public OperationProcessor get(Operation fruitOperation) {
        return operationProcessMap.get(fruitOperation);
    }
}
