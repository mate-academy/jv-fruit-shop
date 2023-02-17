package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.transaction.TransactionHandler;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<Operation, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<Operation, TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public TransactionHandler get(Operation operation) {
        return transactionHandlerMap.get(operation);
    }
}
