package core.basesyntax.strategy;

import java.util.Map;
import core.basesyntax.model.Operation;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public FruitStrategyImpl(Map<Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
