package core.basesyntax.handlers;

import core.basesyntax.model.product.Fruit;

public interface OperationHandler {
    int apply(Fruit fruit, int amount);
}
