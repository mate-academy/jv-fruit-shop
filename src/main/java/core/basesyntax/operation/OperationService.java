package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationService {
    void apply(FruitTransaction fruitTransaction);
}
