package core.basesyntax.service;

import core.basesyntax.service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler execute(FruitTransaction fruitTransaction);
}
