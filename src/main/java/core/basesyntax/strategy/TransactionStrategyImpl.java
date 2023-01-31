package core.basesyntax.strategy;

import core.basesyntax.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<String, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<String, TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public TransactionHandler getHandler(String transactionType) {
        return transactionHandlerMap.get(transactionType);
    }
}
