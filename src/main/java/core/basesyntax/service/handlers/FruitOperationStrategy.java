package core.basesyntax.service.handlers;

import core.basesyntax.model.dto.FruitRecordDto;

public interface FruitOperationStrategy {
    void applyAction(FruitRecordDto fruitRecordDto);
}
