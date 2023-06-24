package core.basesyntax.service.amount;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);
}
