package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
                                    OperationHandler> operationHandlers) {
        this.operationOperationHandlerMap = operationHandlers;
    }

    @Override
    public OperationHandler getOperationStrategy(FruitTransaction.Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
