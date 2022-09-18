package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void doOperation(FruitTransaction fruitTransaction);
}
