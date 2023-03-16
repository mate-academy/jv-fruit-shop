package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationsHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationsHandlerMap) {
        this.operationsHandlerMap = operationsHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationsHandlerMap.get(operation);
    }
}
