package core.basesyntax.service.transactions.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.transactions.BalanceTransactionHandler;
import core.basesyntax.service.transactions.MinusTransactionHandler;
import core.basesyntax.service.transactions.PlusTransactionHandler;
import core.basesyntax.service.transactions.TransactionHandler;
import java.util.HashMap;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<Transaction.TransactionType,
            TransactionHandler> transactionHandlersMap = new HashMap<>();

    public TransactionStrategyImpl() {
        transactionHandlersMap.put(Transaction.TransactionType.BALANCE,
                new BalanceTransactionHandler());
        transactionHandlersMap.put(Transaction.TransactionType.PURCHASE,
                new MinusTransactionHandler());
        transactionHandlersMap.put(Transaction.TransactionType.RETURN,
                new PlusTransactionHandler());
        transactionHandlersMap.put(Transaction.TransactionType.SUPPLY,
                new PlusTransactionHandler());
    }

    @Override
    public TransactionHandler getTransactionHandler(Transaction.TransactionType transactionType) {
        return transactionHandlersMap.get(transactionType);
    }
}
