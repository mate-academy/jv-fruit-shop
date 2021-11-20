package core.basesyntax.service.interfaces;

import core.basesyntax.model.dto.FruitRecordDto;

public interface OperationHandler {
    int apply(FruitRecordDto fruitRecordDto);
}
