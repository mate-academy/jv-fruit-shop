package core.basesyntax.strategy;

import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<String, TransactionHandler> transactionsMap;

    public TransactionStrategyImpl(
            Map<String, TransactionHandler> transactionsMap
    ) {
        this.transactionsMap = transactionsMap;
    }

    @Override
    public TransactionHandler get(String operation) {
        return transactionsMap.get(operation);
    }
}
