package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.OperationBalanceHandler;
import core.basesyntax.service.operation.impl.OperationPurchaseHandler;
import core.basesyntax.service.operation.impl.OperationReturnHandler;
import core.basesyntax.service.operation.impl.OperationSupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl() {
        this.operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new OperationBalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationPurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new OperationReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new OperationSupplyHandler());
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
