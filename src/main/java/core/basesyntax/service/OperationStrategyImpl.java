package core.basesyntax.service;

import core.basesyntax.model.Record;
import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Record.OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Record.OperationType,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Record.OperationType operationType) {
        return operationHandlerMap.get(operationType);
    }
}
