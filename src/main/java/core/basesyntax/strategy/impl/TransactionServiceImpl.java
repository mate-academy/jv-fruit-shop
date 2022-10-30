package core.basesyntax.strategy.impl;

import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionHandler;
import java.util.HashMap;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final HashMap<Operation, TransactionHandler> transactionMap;

    public TransactionServiceImpl(HashMap<Operation, TransactionHandler> transactionMap) {
        this.transactionMap = transactionMap;
    }

    public void applyTransactions(List<FruitTransaction> actions) {
        actions.forEach(this::handleTransaction);
    }

    private void handleTransaction(FruitTransaction fruitTransaction) {
        transactionMap.get(fruitTransaction.getOperation())
                .apply(fruitTransaction);
    }
}
