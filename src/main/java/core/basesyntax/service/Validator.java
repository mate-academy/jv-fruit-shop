package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface Validator {
    void checkPurchaseValidation(FruitRecordDto fruitRecordDto);
}
