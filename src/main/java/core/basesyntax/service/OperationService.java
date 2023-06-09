package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.stategy.OperationStrategy;
import java.util.List;

public class OperationService {
    private final OperationStrategy operationStrategy;

    public OperationService(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void toFormStorage(List<FruitTransaction> parseData) {
        for (FruitTransaction transaction : parseData) {
            operationStrategy.get(transaction.getOperation()).handle(transaction);
        }
    }
}
