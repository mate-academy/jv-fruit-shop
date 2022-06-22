package strategy;

import servise.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<String, TransactionHandler> transactionHandlers;

    public TransactionStrategyImpl(Map<String, TransactionHandler> transactionHandlers) {
        this.transactionHandlers = transactionHandlers;
    }

    @Override
    public TransactionHandler get(String operation) {
        return transactionHandlers.get(operation);
    }
}
