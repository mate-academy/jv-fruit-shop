package core.basesyntax.service;

import core.basesyntax.service.operations.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, Operation> operationMap;

    public OperationStrategyImpl(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation getOperation(String operationSymbol) {
        return operationMap.get(operationSymbol);
    }
}
