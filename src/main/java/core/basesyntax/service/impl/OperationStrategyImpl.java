package core.basesyntax.service.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final String MESSAGE = "Invalid input operation";
    private final Map<FruitRecord.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitRecord.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitRecord.Operation operation) {
        if (operationHandlerMap.get(operation) == null) {
            throw new RuntimeException(MESSAGE);
        }
        return operationHandlerMap.get(operation);
    }
}
