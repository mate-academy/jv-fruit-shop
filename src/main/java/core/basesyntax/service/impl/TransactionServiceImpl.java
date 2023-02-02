package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionService;
import core.basesyntax.transaction.TransactionHandler;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public void handleTransaction(
              TransactionHandler transactionHandler,
              String fruitName,
              int amount
    ) {
        transactionHandler.callTransaction(fruitName, amount);
    }
}
