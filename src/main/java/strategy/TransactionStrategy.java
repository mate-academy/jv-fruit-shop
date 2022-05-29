package strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class TransactionStrategy {
    private Map<FruitTransaction.Operation, TransactionService> transactionServiceMap;

    public TransactionStrategy() {
        transactionServiceMap = new HashMap<>();
        transactionServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionService());
        transactionServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransaction());
        transactionServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionService());
        transactionServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionService());
    }

    public TransactionService getTransactionService(FruitTransaction.Operation operation) {
        return transactionServiceMap.get(operation);
    }
}
