package core.basesyntex.service;

import core.basesyntex.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
