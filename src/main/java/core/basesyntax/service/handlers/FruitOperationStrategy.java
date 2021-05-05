package core.basesyntax.service.handlers;

import core.basesyntax.dto.FruitRecordDto;

public interface FruitOperationStrategy {
    int applyAction(FruitRecordDto fruitRecordDto);
}
