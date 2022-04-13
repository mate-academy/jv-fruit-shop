package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, FruitOperationHandler> operationHandlerMap
            = new HashMap<>();

    @Override
    public FruitOperationHandler get(FruitTransaction.Operation operation) {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new FruitOperationHandlerBalance());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new FruitOperationHandlerPurchase());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new FruitOperationHandlerReturn());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new FruitOperationHandlerSupply());
        return operationHandlerMap.get(operation);
    }
}

