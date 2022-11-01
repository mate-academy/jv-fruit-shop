package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationValidator {
    FruitTransaction.Operation validate(String operation);
}
