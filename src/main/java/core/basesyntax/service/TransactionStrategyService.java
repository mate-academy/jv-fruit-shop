package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionService;
import java.util.Map;

public class TransactionStrategyService {
    private final Map<FruitTransaction.Operation, TransactionService> operationStrategies;

    public TransactionStrategyService(Map<FruitTransaction.Operation,
            TransactionService> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    public TransactionService getTransactionService(FruitTransaction transaction) {
        if (!operationStrategies.containsKey(transaction.getOperation())) {
            throw new IllegalStateException("Unexpected transaction operation: "
                    + transaction.getOperation());
        }
        return operationStrategies.get(transaction.getOperation());
    }
}
