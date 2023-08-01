package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.interfaces.TransactionStrategy;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<Operation, TransactionHandler> transactionsHandlersMap;

    public TransactionStrategyImpl(Map<Operation, TransactionHandler> transactionsHandlersMap) {
        this.transactionsHandlersMap = transactionsHandlersMap;
    }

    @Override
    public TransactionHandler get(Operation operation) {
        return transactionsHandlersMap.get(operation);
    }
}
