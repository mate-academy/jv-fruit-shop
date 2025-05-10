package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationDefStrategy {
    FruitTransaction.Operation get(String code);
}
