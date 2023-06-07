package core.basesyntax.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.service.GetOperationStrategy;
import core.basesyntax.util.Operation;
import java.util.Map;

public class GetOperationStrategyImpl implements GetOperationStrategy {
    private final Map<Operation, OperationHandler> operationTypeMap;

    public GetOperationStrategyImpl(Map<Operation, OperationHandler> operationTypeMap) {
        this.operationTypeMap = operationTypeMap;
    }

    @Override
    public OperationHandler getOperationStrategy(Operation operation) {
        return operationTypeMap.get(operation);
    }
}
