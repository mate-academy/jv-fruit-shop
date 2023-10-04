package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map handlerMap) {
        this.operationHandlerMap = handlerMap;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlerMap() {
        return operationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
