package core.basesyntax.strategy.operation.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.util.TransactionHandler;
import java.util.List;

public class FruitService {
    private final Strategy strategy;

    public FruitService(Strategy strategy) {
        this.strategy = strategy;
    }

    public void processTransaction(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            Operation handler = strategy.getByOperation(transaction.getOperation());
            handler.apply(new TransactionHandler(), transaction);
        }
    }
}
