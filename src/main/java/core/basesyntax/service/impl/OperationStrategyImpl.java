package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void process(OperationType operationType, Fruit fruit) {
        operationMap.get(operationType.getOperation()).doOperation(fruit);
    }
}
