package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface OperationStrategy {
    int doOperation(FruitRecordDto fruitRecordDto);
}
