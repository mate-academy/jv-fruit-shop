package core.basesyntax.strategy;

import core.basesyntax.model.FruitModel;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitModel.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitModel.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitModel fruitModel) {
        return operationHandlerMap.get(fruitModel.getOperation());
    }
}
