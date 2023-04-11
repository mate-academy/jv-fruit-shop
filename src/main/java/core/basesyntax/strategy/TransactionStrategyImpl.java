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
    public void process(FruitTransaction transaction) {
        transactionHandlerMap.get(transaction.getOperation()).operate(transaction);
    }
}
