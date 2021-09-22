package core.basesyntax.service;

import core.basesyntax.Record;
import core.basesyntax.exceptions.ValidationException;
import java.util.List;

public interface Validator {
    void validate(List<Record> recordsList) throws ValidationException;
}
