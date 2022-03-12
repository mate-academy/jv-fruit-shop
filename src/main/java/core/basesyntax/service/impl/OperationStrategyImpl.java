package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, Operation> operationMap;

    public OperationStrategyImpl(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void startOperation(OperationType operationType, Fruit fruit) {
        operationMap.get(operationType.getOperation()).doOperation(fruit);
    }
}
