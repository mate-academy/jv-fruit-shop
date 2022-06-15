package core.basesyntax.strategy;

import core.basesyntax.strategy.transaction.FruitTransaction;
import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> transactionsMap;

    public TransactionStrategyImpl(
            Map<FruitTransaction.Operation, TransactionHandler> transactionsMap
    ) {
        this.transactionsMap = transactionsMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return transactionsMap.get(operation);
    }
}
