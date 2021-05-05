package core.basesyntax.handlers;

import core.basesyntax.model.dtos.FruitDtoTransaction;

public interface FruitOperationHandler {
    int apply(FruitDtoTransaction fruitDtoTransaction);
}
