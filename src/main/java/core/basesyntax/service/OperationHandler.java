package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface OperationHandler {
    int apply(FruitRecordDto fruitRecordDto);
}
