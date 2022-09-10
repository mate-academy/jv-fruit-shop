package core.basesyntax.strategy.Impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationProcessMap;

    public OperationStrategyImpl() {
        this.operationProcessMap = new HashMap<>();
        operationProcessMap.put(Operation.BALANCE,
                new QuantityAddOperationHandler());
        operationProcessMap.put(Operation.SUPPLY,
                new QuantityAddOperationHandler());
        operationProcessMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationProcessMap.put(Operation.RETURN,
                new QuantityAddOperationHandler());
    }

    @Override
    public OperationHandler get(Operation fruitOperation) {
        return operationProcessMap.get(fruitOperation);
    }
}
