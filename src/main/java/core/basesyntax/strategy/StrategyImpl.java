package core.basesyntax.strategy;

import core.basesyntax.model.Store;
import core.basesyntax.strategy.operation.Handler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<Store.Operation, Handler> operationHandlerMap;

    public StrategyImpl(Map<Store.Operation, Handler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public Handler getOperation(Store.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
