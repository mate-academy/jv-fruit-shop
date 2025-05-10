package core.basesyntax.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Integer getHandler(FruitTransaction fruitTransaction);
}
