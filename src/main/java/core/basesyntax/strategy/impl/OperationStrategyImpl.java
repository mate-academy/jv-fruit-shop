package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperation());
    }

    @Override
    public OperationHandler chooseHandler(FruitTransaction transaction) {
        return operationHandlerMap.get(transaction.getOperation());
    }
}
