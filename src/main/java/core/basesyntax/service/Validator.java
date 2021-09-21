package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;

public interface Validator {
    boolean validateRecord(FruitRecordDto record);
}
