package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Type, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Type, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Type type) {
        OperationHandler handler = operationHandlerMap.get(type);

        if (handler == null) {
            throw new RuntimeException("No handler yet for type: " + type);
        }

        return handler;
    }
}
