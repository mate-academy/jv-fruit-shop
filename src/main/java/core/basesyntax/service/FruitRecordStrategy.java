package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.handler.RecordHandler;

public interface FruitRecordStrategy {
    RecordHandler get(FruitRecordDto.Type type);
}
