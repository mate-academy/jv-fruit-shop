package core.basesyntax.operations;

import core.basesyntax.model.FruitOperationDto;

public interface OperationHandler {
    int changeQuantity(FruitOperationDto fruitOperationDto);
}
