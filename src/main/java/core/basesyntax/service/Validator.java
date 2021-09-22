package core.basesyntax.service;

import core.basesyntax.Record;
import core.basesyntax.exceptions.ValidationException;
import java.util.List;

public interface Validator {
    void validateData(List<Record> recordsList) throws ValidationException;
}
