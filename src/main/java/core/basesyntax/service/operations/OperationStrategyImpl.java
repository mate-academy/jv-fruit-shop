package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction fruitTransaction) {
        return operationHandlerMap.get(fruitTransaction.getOperation());
    }

}
