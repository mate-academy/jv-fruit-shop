package core.basesyntax.strategy;

import core.basesyntax.model.OperationsWithFruits;
import core.basesyntax.operationshandlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationsWithFruits, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(
            Map<OperationsWithFruits, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(OperationsWithFruits operation) {
        return operationHandlerMap.get(operation);
    }
}
