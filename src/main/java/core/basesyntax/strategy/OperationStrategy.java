package core.basesyntax.strategy;

import core.basesyntax.dto.FruitRecordDto;

public interface OperationStrategy {
    int apply(FruitRecordDto fruitRecordDto);
}
