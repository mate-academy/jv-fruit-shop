package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandle {
    void handle(FruitTransaction transaction);
}
