package core.basesyntax.validation;

import core.basesyntax.model.Transaction;

public interface Validator {
    boolean isValidLine(String[] line);
}
