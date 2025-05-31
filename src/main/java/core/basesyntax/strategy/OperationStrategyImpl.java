package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitOperation.Operation,OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<FruitOperation.Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitOperation.Operation type) {
        return operationOperationHandlerMap.get(type);
    }
}
