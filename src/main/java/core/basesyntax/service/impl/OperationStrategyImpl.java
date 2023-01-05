package core.basesyntax.service.impl;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import java.util.Map;
import jdk.dynalink.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitsTranslation.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitsTranslation.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
