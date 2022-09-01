package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.TransactionHandlerStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private TransactionHandlerStrategy strategy;

    public TransactionServiceImpl(TransactionHandlerStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void executeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.get(transaction.getOperation()).apply(transaction);
        }
    }
}
