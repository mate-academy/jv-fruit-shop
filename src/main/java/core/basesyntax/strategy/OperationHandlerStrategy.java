package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationHandlerStrategy {
    private Map<FruitTransaction.Operation,
            OperationHandler> handlerMap;

    public OperationHandlerStrategy(Map<FruitTransaction.Operation,
            OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public OperationHandler get(FruitTransaction transaction) {
        operationVerification(transaction.getOperation());
        return handlerMap.get(transaction.getOperation());
    }

    private void operationVerification(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation shouldn't be null");
        }
        if (!handlerMap.containsKey(operation)) {
            throw new RuntimeException("Have to create strategy of operator "
                    + operation + ". It doesn't exist");
        }
    }
}
