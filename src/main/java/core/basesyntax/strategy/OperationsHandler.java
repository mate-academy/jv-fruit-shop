package core.basesyntax.strategy;

import core.basesyntax.dto.FruitDto;

public interface OperationsHandler {
    int apply(FruitDto fruitDto);
}
