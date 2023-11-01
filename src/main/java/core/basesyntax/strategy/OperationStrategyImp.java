package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class OperationStrategyImp implements  OperationStrategy{
    private Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImp(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return operationOperationHandlerMap.get(type);
    }
}
