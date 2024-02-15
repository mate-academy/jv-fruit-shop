package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void performOperation(FruitTransaction fruitTransaction);
}
