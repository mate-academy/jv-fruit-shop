package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.impl.BalanceTransactionHandler;
import core.basesyntax.service.impl.PurchaseTransactionHandler;
import core.basesyntax.service.impl.ReturnTransactionHandler;
import core.basesyntax.service.impl.SupplyTransactionHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private Map<String, TransactionHandler> operationMap;

    public OperationStrategy() {
        operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE.getCode(), new BalanceTransactionHandler());
        operationMap.put(Operation.SUPPLY.getCode(), new SupplyTransactionHandler());
        operationMap.put(Operation.PURCHASE.getCode(), new PurchaseTransactionHandler());
        operationMap.put(Operation.RETURN.getCode(), new ReturnTransactionHandler());
    }

    public TransactionHandler getOperationHandler(Operation operation) {
        TransactionHandler transactionHandler = operationMap.get(operation.getCode());
        if (transactionHandler == null) {
            throw new RuntimeException("This operation doesn't exist " + operation);
        }
        return transactionHandler;
    }
}
