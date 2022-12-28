package core.basesyntax.strategy.impl;

import core.basesyntax.operations.Operational;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, Operational> operationMap;

    public OperationStrategyImpl(Map<String, Operational> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operational get(String typeOfOperation) {
        return operationMap.get(typeOfOperation);
    }
}
