package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public TransactionServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void addTransferToStorage(List<Transaction> transactions) {
        Transaction transaction;
        for (int i = 1; i < transactions.size(); i++) {
            transaction = transactions.get(i);
            if (!Storage.fruits.containsKey(transaction.getFruit())) {
                Storage.fruits.put(transaction.getFruit(),
                        transaction.getQuantity());
            } else {
                Storage.fruits.put(transaction.getFruit(),
                        operationHandlerStrategy.get(transaction.getOperation())
                        .apply(Storage.fruits.get(transaction.getFruit()),
                                transaction.getQuantity()));
            }
        }
    }
}
