package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;

public interface FruitRecordDtoParser {
    FruitRecordDto parseRecord(String record);
}
