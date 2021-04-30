package core.basesyntax.service;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.handler.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public Optional<OperationHandler> get(String operation) {
        return Optional.ofNullable(operationHandlerMap.get(operation));
    }
}
