package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionStrategy transactionStrategy;

    public TransactionServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        transactionStrategy.get(transaction.getOperation())
                .doFruitTransaction(transaction.getFruitName(), transaction.getQuantity());
    }
}
