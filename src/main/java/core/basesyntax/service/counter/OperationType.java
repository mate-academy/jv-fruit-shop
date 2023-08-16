package core.basesyntax.service.counter;

import core.basesyntax.service.transaction.FruitTransaction;

public interface OperationType {

    void makeOperationWithFruit(FruitTransaction fruitTransaction);
}
