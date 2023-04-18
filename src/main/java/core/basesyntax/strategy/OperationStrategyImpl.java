package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Fruit.Operation, Operation> operationMap;

    public OperationStrategyImpl(Map<Fruit.Operation, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(Fruit.Operation operation) {
        return operationMap.get(operation);
    }
}
