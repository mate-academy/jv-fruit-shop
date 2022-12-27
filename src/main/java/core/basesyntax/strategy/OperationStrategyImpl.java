package core.basesyntax.strategy;

import core.basesyntax.operations.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, Operation> operationMap;

    public OperationStrategyImpl(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(String typeOfOperation) {
        return operationMap.get(typeOfOperation);
    }
}
