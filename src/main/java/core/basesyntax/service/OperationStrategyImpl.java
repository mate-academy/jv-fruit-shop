package core.basesyntax.service;

import core.basesyntax.dao.strategy.FruitOperations;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, FruitOperations> operationsMap;

    public OperationStrategyImpl(Map<String, FruitOperations> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public FruitOperations get(String operation) {
        return operationsMap.get(operation);
    }
}
