package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;

public interface OperationValidator {
    FruitTransaction.Operation validate(String operation);
}
