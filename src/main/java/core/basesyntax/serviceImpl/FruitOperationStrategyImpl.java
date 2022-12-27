package core.basesyntax.serviceImpl;

import core.basesyntax.service.FruitOperationStrategy;
import core.basesyntax.operations.Operation;

import java.util.Map;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private Map<String, Operation> operationMap;

    public FruitOperationStrategyImpl(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(String typeOfOperation) {
        return operationMap.get(typeOfOperation);
    }
}
