package core.basesyntax.service.handlers;

import core.basesyntax.dto.FruitRecordDto;

public interface RecordHandler {
    long applyAction(FruitRecordDto fruitRecordDto);
}
