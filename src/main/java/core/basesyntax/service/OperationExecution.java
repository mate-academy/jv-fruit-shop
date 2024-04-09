package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationExecution {
    void execute(FruitTransaction fruitTransaction);
}
