package core.basesyntax.service.impl.operation;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    int MIN_FRUIT_QUANTITY = 0;
    boolean doOperation(Fruit fruit, int quantity);
}
