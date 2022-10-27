package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionProducer;
import java.util.HashMap;
import java.util.List;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final HashMap<Operation, TransactionProducer> transactionMap;

    public TransactionStrategyImpl(HashMap<Operation, TransactionProducer> transactionMap) {
        this.transactionMap = transactionMap;
    }

    public void distributeTransactions(List<FruitTransaction> actions) {
        actions.forEach(this::transactionStrategy);
    }

    private void transactionStrategy(FruitTransaction fruitTransaction) {
        transactionMap.get(fruitTransaction.getOperation())
                .produceTransaction(fruitTransaction);
    }
}
