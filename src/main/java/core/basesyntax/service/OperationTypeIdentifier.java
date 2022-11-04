package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationTypeIdentifier {
    FruitTransaction.Operation identifyOperationType(String inputOperation);
}
