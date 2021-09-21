package core.basesyntax.services.operations;

import core.basesyntax.dto.FruitDto;

public interface OperationHandler {
    Integer apply(FruitDto fruitDto);
}
