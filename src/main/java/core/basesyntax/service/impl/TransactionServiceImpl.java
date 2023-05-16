package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionStrategy activitiesStrategy;

    public TransactionServiceImpl(TransactionStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public void makeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            activitiesStrategy.getHandler(transaction.getOperation())
                    .transaction(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
