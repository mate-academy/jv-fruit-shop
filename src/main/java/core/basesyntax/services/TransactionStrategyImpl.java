package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.transaction.Transaction;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, Transaction> transactionMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, Transaction> transactionMap) {
        this.transactionMap = transactionMap;
    }

    @Override
    public Transaction get(FruitTransaction.Operation operation) {
        return transactionMap.get(operation);
    }
}
