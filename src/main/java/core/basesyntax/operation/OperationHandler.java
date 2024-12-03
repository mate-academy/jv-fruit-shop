package core.basesyntax.operation;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationHandler {

    void apply(FruitTransaction fruitTransaction);
}
