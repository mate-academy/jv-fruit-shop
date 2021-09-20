package core.basesyntax.validator;

import core.basesyntax.model.FruitRecord;

public interface Validator {
    boolean validateRecord(FruitRecord record);
}
