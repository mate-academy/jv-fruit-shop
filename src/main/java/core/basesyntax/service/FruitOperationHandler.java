package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface FruitOperationHandler {
    int apply(FruitRecordDto fruitRecordDto);
}
