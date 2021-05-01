package core.basesyntax.service.interfaces;

import core.basesyntax.model.dto.FruitRecordDto;

public interface FruitAvailabilityValidator {
    void checkAvailability(FruitRecordDto fruitRecordDto);
}
