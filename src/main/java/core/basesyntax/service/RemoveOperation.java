package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public class RemoveOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        return 0;
    }
}
