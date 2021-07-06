package core.basesyntax.srategy;

import core.basesyntax.dto.FruitDto;

public interface OperationHandler {
    int apply(FruitDto fruitDto);
}
