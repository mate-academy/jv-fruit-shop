package core.basesyntax.operations;

import core.basesyntax.model.FruitTransaction;

public interface Operation {
    void executeOperation(FruitTransaction fruitTransaction);
}
