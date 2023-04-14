package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation transaction) {
        return transactionHandlerMap.get(transaction);
    }
}
