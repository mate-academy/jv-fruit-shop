package service.transaction.strategy;

import java.util.Map;
import model.Transaction;
import service.transaction.strategy.type.TransactionHandler;

public class ProductTransactionStrategy implements TransactionStrategy {
    private Map<Transaction.Type, TransactionHandler> transactionHandlers;

    public ProductTransactionStrategy(Map<Transaction.Type,
            TransactionHandler> transactionHandlers) {
        this.transactionHandlers = transactionHandlers;
    }

    @Override
    public TransactionHandler getHandler(Transaction.Type type) {
        return transactionHandlers.get(type);
    }
}
