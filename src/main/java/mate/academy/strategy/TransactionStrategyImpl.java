package mate.academy.strategy;//*

import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.transaction.TransactionHandler;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> transactionHandlersMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> transactionHandlersMap) {
        this.transactionHandlersMap = transactionHandlersMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return transactionHandlersMap.get(operation);
    }
}
