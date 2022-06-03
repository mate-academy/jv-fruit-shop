package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class TransactionStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> transactionServiceMap;

    public TransactionStrategy() {
        transactionServiceMap = new HashMap<>();
        transactionServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandler());
        transactionServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler());
        transactionServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler());
        transactionServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler());
    }

    public TransactionHandler getTransactionService(FruitTransaction.Operation operation) {
        return transactionServiceMap.get(operation);
    }
}
