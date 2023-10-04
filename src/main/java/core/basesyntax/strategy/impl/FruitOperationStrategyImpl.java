package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.FruitOperationStrategy;
import java.util.Map;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private Map<FruitOperation, FruitOperationHandler> operationHandlerMap;

    public FruitOperationStrategyImpl(Map<FruitOperation,
            FruitOperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public FruitOperationHandler getHandler(FruitOperation fruitOperation) {
        return operationHandlerMap.get(fruitOperation);
    }
}
