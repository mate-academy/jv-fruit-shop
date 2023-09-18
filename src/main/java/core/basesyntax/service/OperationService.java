package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class OperationService {
    private final OperationStrategy operationStrategy;

    public OperationService(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void processOperation(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.get(transaction.getOperation()).handle(transaction);
        }
    }
}
