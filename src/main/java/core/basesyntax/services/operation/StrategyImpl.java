package core.basesyntax.services.operation;

import core.basesyntax.model.Operation;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<Operation.Type, Handler> operationHandlerMap;

    public StrategyImpl(Map<Operation.Type, Handler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public Handler get(Operation.Type operation) {
        if (operationHandlerMap.get(operation) == null) {
            throw new RuntimeException("Unsupported operation");
        }
        return operationHandlerMap.get(operation);
    }
}
