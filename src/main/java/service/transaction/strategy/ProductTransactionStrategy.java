package service.transaction.strategy;

import java.util.Map;
import model.FruitTransaction;
import service.transaction.strategy.type.TransactionHandler;

public class ProductTransactionStrategy implements TransactionStrategy {
    private Map<FruitTransaction.OperationType, TransactionHandler> transactionHandlers;

    public ProductTransactionStrategy(Map<FruitTransaction.OperationType,
            TransactionHandler> transactionHandlers) {
        this.transactionHandlers = transactionHandlers;
    }

    @Override
    public TransactionHandler getHandler(FruitTransaction.OperationType type) {
        return transactionHandlers.get(type);
    }
}
