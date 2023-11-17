package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class HandlerStrategy {

    private final Map<Operation, OperationHandler> strategyMap;

    public HandlerStrategy(Map<Operation, OperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public Map<Operation, OperationHandler> getStrategyMap() {
        return strategyMap;
    }

    public OperationHandler getHandlerByOperationType(Operation operation) {
        return strategyMap.get(operation);
    }
}
