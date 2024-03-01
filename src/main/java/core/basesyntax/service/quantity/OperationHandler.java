package core.basesyntax.service.quantity;

import core.basesyntax.entity.FruitTransaction;

public interface OperationHandler {

    FruitTransaction getTransitionTransaction(FruitTransaction fruitTransaction);
}
