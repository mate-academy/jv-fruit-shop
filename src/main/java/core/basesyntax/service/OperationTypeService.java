package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationTypeService {
    FruitTransaction.Operation getOperationType(String operation);
}
