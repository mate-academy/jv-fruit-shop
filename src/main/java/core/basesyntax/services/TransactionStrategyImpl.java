package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.transaction.OperationHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> transactionMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> transactionMap) {
        this.transactionMap = transactionMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return transactionMap.get(operation);
    }
}
