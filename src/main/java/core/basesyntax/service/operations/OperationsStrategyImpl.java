package core.basesyntax.service.operations;

import java.util.Map;

public class OperationsStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationOperationsMap;

    public OperationsStrategyImpl(Map<Operation, OperationHandler> operationOperationsMap) {
        this.operationOperationsMap = operationOperationsMap;
    }

    @Override
    public OperationHandler chooseOperation(Operation operation) {
        return operationOperationsMap.get(operation);
    }
}
