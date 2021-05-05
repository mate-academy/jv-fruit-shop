package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface OperationStrategy {
    int operation(FruitRecordDto fruitRecordDto);
}
