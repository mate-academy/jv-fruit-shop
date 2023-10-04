package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;
import java.util.Map;

public class OperationStrategyImpl {
    private final Map<FruitTransaction.Operation, OperationService> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationService> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationServiceImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationServiceImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationServiceImpl());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationServiceImpl());
    }

    public OperationService getOperation(FruitTransaction.Operation type) {
        return operationHandlerMap.get(type);
    }
}
