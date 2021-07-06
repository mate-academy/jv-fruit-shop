package core.basesyntax.strategy;

import core.basesyntax.dto.FruitDto;

public interface OperationHandler {
    int apply(FruitDto fruitDto);
}
