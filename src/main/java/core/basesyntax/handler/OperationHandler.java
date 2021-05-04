package core.basesyntax.handler;

import core.basesyntax.dto.FruitRecordDto;

public interface OperationHandler {
    int apply(FruitRecordDto fruitRecordDto);
}
