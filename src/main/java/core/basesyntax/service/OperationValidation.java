package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface OperationValidation {
    Operation validate(String operation);
}
