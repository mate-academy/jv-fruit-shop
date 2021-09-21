package core.basesyntax.services.operations;

import core.basesyntax.dto.FruitDto;

public interface OperationHandler {
    int apply(FruitDto fruitDto);
}
