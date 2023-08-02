package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.Operation;
import java.util.Map;

public class StrategyOperationImpl implements OperationStrategy {
    @Override
    public OperationHandler getOperation(Operation operation,
                                         Map<Operation, OperationHandler> operationHandlerMap) {
        return operationHandlerMap.get(operation);
    }
}
