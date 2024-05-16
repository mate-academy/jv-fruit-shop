package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(String code);

    int getCalculatedCount(int count, int quantity, FruitTransaction.Operation operation);
}
