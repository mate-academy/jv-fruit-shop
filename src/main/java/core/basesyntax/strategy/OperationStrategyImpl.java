package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, FruitOperationsHandler> operationHandlerMap
            = new HashMap<>();

    @Override
    public FruitOperationsHandler get(FruitTransaction.Operation operation) {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new FruitOperationsHandlerBalance());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new FruitOperationsHandlerPurchase());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new FruitOperationsHandlerReturn());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new FruitOperationsHandlerSupply());

        return operationHandlerMap.get(operation);
    }
}

