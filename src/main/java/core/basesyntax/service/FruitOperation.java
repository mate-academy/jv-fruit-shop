package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface FruitOperation {
    int apply(FruitRecordDto fruitRecordDto);
}
