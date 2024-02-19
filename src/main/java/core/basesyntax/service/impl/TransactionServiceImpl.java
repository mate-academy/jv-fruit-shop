package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public void executeTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            TransactionStrategy.getTransactionService(fruitTransaction.getOperation())
                    .calculateTransaction(fruitTransaction);
        }
    }
}
