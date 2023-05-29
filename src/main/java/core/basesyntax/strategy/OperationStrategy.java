package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;
    public OperationStrategy (Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new Balance());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new Supply());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new Purchase());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new Return());
    }

    public OperationHandler get(FruitTransaction.Operation type) {
        return operationHandlerMap.get(type);
    }
}
