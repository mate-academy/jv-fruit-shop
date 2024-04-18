package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class TransactionStrategy {
    private final Map<FruitTransaction.Operation,
            OperationHandler> operationToHandlerMap = new HashMap<>();

    public TransactionStrategy() {
        operationToHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceService());
        operationToHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseService());
        operationToHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnService());
        operationToHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyService());
    }

    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return operationToHandlerMap.get(operation);
    }
}
